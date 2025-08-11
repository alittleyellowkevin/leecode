package hotcode100;

import java.util.Arrays;
import java.util.List;

public class leecode_208_实现Trie {
    GraphNode[] graph = new GraphNode[26];
    public leecode_208_实现Trie() {
    }

    public void insert(String word) {
        char[] charsArray = word.toCharArray();
        GraphNode[] level = graph;
        for (int i=0; i<charsArray.length; i++) {
            int num = charsArray[i] - 'a';
            if(level[num] == null) {
                level[num] = new GraphNode();
            }
            if( i == charsArray.length -1){
                level[num].value = 1;
            }
            level = level[num].graphNodes;
        }
    }

    public boolean search(String word) {
        char[] charsArray = word.toCharArray();
        GraphNode[] level = graph;
        for(int i=0; i<charsArray.length; i++){
            int num = charsArray[i] - 'a';
            if(level[num] == null || (i == charsArray.length-1 && level[num].value != 1)){
                return false;
            }
            level = level[num].graphNodes;
        }
        return true;
    }

    public boolean startsWith(String prefix) {
        char[] charsArray = prefix.toCharArray();
        GraphNode[] level = graph;
        for(int i=0; i<charsArray.length; i++){
            int num = charsArray[i] - 'a';
            if(level[num] == null){
                return false;
            }
            level = level[num].graphNodes;
        }
        return true;
    }

    class GraphNode {
        int value = 0;
        GraphNode[] graphNodes = new GraphNode[26];

    }
}
