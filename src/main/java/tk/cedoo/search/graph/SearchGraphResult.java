package tk.cedoo.search.graph;

import java.util.ArrayList;
import java.util.List;

import tk.cedoo.search.pojo.Link;
import tk.cedoo.vo.Node;
import tk.cedoo.search.pojo.SearchResult;
/**
 * 搜索结果
 * @author Administrator
 *
 */
public class SearchGraphResult extends SearchResult{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3791826094429107156L;
	private List<Node> nodes = new ArrayList<Node>();    //节点
	private List<Link> edges = new ArrayList<Link>();    //边
	public List<Node> getNodes() {
		return nodes;
	}
	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}
	public List<Link> getEdges() {
		return edges;
	}
	public void setEdges(List<Link> edges) {
		this.edges = edges;
	}
	
}
