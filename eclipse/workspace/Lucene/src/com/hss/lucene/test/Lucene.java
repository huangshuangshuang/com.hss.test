package com.hss.lucene.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.util.CharArraySet;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.QueryBuilder;

public class Lucene {
	private Analyzer analyzer;

	public static void main(String[] args) {
		Lucene lucene = new Lucene();
/*
		File[] files = { new File("F:\\test\\eclipse\\data\\index.txt"),
				new File("F:\\test\\eclipse\\data\\index1.txt"), new File("F:\\test\\eclipse\\data\\index2.txt"),
				new File("F:\\test\\eclipse\\data\\index3.txt"), new File("F:\\test\\eclipse\\data\\index0.txt") };
		for (int i = 0; i < files.length; i++) {
			lucene.create(files[i]);
		}*/

		lucene.index("大丰");
	}

	public void create(File file) {
		IndexWriter indexWriter = null;
		try {
			@SuppressWarnings("resource")
			BufferedReader reader = new BufferedReader(new FileReader(file));
			Set<Character> set = new HashSet<Character>();
			String s = null;
			while ((s = reader.readLine()) != null) {
				for (int i = 0; i < s.length(); i++) {
					if (!",|.|，|。|；|;|\\!|！|?|？|、|/|'|\"|‘|’|“|”|》|《|<|>| ".matches(String.valueOf(s.charAt(i))))
						set.add(s.charAt(i));
				}
			}
			CharArraySet arraySet = new CharArraySet(set, true);
			analyzer = new StandardAnalyzer(arraySet);
			Directory directory = FSDirectory.open(Paths.get("F:/test/eclipse/index"));
			IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
			indexWriter = new IndexWriter(directory, indexWriterConfig);
			indexWriter.addDocument(addDoc(file));
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			if (indexWriter != null) {
				try {
					indexWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public void index(String context) {
		IndexReader reader = null;
		try {
			Set<Character> set = new HashSet<Character>();
			for (int i = 0; i < context.length(); i++) {
				if (!",|.|，|。|；|;|\\!|！|?|？|、|/|'|\"|‘|’|“|”|》|《|<|>| ".matches(String.valueOf(context.charAt(i))))
					set.add(context.charAt(i));
			}
			CharArraySet arraySet = new CharArraySet(set, true);
			analyzer = new StandardAnalyzer(arraySet);
			QueryBuilder q = new QueryBuilder(analyzer);
			Query query = q.createBooleanQuery("contents", context);
			int hitsPerPage = 10;
			Directory directory = FSDirectory.open(Paths.get("F:/test/eclipse/index"));
			reader = DirectoryReader.open(directory);
			IndexSearcher searcher = new IndexSearcher(reader);
			TopScoreDocCollector collector = TopScoreDocCollector.create(hitsPerPage);
			searcher.search(query, collector);
			ScoreDoc[] hits = collector.topDocs(collector.getTotalHits()).scoreDocs;
			System.out.println("Found " + hits.length + " hits.");
			for (int i = 0; i < hits.length; i++) {
				int docId = hits[i].doc;
				Document d = searcher.doc(docId);
				System.out.println((i + 1) + ". " + d.get("path") + "\t" + d.get("time"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private Document addDoc(File file) {
		Document doc = new Document();
		doc.add(new StringField("filename", file.getName(), Field.Store.YES));
		doc.add(new StringField("time", new SimpleDateFormat().format(System.currentTimeMillis()), Field.Store.NO));
		doc.add(new StringField("path", file.toString(), Field.Store.YES));
		try {
			doc.add(new TextField("contents", new FileReader(file)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return doc;
	}

}
