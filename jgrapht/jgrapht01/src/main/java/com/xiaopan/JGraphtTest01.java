package com.xiaopan;


import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.traverse.DepthFirstIterator;

import java.net.URI;
import java.rmi.server.ExportException;
import java.util.Iterator;

/**
 * @author ：panleilei
 * @description
 * @modified By：
 * @version:
 * @date ：Created in 2023/4/28 13:41
 */
public class JGraphtTest01 {
    public static void main(String[] args) {
        Graph<String, DefaultEdge> stringGraph = createStringGraph();

        // note undirected edges are printed as: {<v1>,<v2>}
        System.out.println("-- toString output");
        System.out.println(stringGraph);
        System.out.println();


//        // create a graph based on URI objects
//        Graph<URI, DefaultEdge> hrefGraph = createHrefGraph();
//
//        // find the vertex corresponding to www.jgrapht.org
//        URI start = hrefGraph
//                .vertexSet().stream().filter(uri -> uri.getHost().equals("www.jgrapht.org")).findAny()
//                .get();
//
//
//        // perform a graph traversal starting from that vertex
//        System.out.println("-- traverseHrefGraph output");
//        traverseHrefGraph(hrefGraph, start);
//        System.out.println();
//
//        System.out.println("-- renderHrefGraph output");
//        renderHrefGraph(hrefGraph);
//        System.out.println();
    }


    private static void traverseHrefGraph(Graph<URI, DefaultEdge> hrefGraph, URI start)
    {
        Iterator<URI> iterator = new DepthFirstIterator<>(hrefGraph, start);
        while (iterator.hasNext()) {
            URI uri = iterator.next();
            System.out.println(uri);
        }
    }

//    private static void renderHrefGraph(Graph<URI, DefaultEdge> hrefGraph)
//            throws ExportException
//    {
//
//        DOTExporter<URI, DefaultEdge> exporter =
//                new DOTExporter<>(v -> v.getHost().replace('.', '_'));
//        exporter.setVertexAttributeProvider((v) -> {
//            Map<String, Attribute> map = new LinkedHashMap<>();
//            map.put("label", DefaultAttribute.createAttribute(v.toString()));
//            return map;
//        });
//        Writer writer = new StringWriter();
//        exporter.exportGraph(hrefGraph, writer);
//        System.out.println(writer.toString());
//    }

    private static Graph<URI, DefaultEdge> createHrefGraph() {
        Graph<URI, DefaultEdge> g = new DefaultDirectedGraph<>(DefaultEdge.class);
        URI google = URI.create("http://www.google.com");
        URI wikipedia = URI.create("http://www.wikipedia.org");
        URI jgrapht = URI.create("http://www.jgrapht.org");

        // add the vertices
        g.addVertex(google);
        g.addVertex(wikipedia);
        g.addVertex(jgrapht);

        // add edges to create linking structure
        g.addEdge(jgrapht, wikipedia);
        g.addEdge(google, jgrapht);
        g.addEdge(google, wikipedia);
        g.addEdge(wikipedia, google);
        return g;
    }

    private static Graph<String,DefaultEdge> createStringGraph() {
        // q: Graph 的实现类都有哪些?
        // A: 有很多，比如：DefaultDirectedGraph, DefaultUndirectedGraph, SimpleGraph, SimpleDirectedGraph, SimpleWeightedGraph, SimpleDirectedWeightedGraph
        // q: 为什么要有这么多实现类?
        // A: 为了满足不同的需求，比如有向图，无向图，带权图等等
        // q:DefaultDirectedGraph 和 SimpleDirectedGraph 有什么区别?
        // A: DefaultDirectedGraph 是有向图，SimpleDirectedGraph 是有向图，但是 DefaultDirectedGraph 是有向图的默认实现，SimpleDirectedGraph 是有向图的简单实现

        Graph<String,DefaultEdge> g = new SimpleGraph<>(DefaultEdge.class);
        String v1 = "55";
        String v2 = "13001";
        String v3 = "13";
        String v4 = "12";
        String v5 = "13002";

        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
        g.addVertex(v5);

        g.addEdge(v1,v2);


        g.inDegreeOf(v1);




        // add edges to create a circuit
        g.addEdge(v1, v2);
        g.addEdge(v2, v3);
        g.addEdge(v3, v4);
        g.addEdge(v4, v1);
        g.addEdge(v3, v4);

        return g;
    }

}
