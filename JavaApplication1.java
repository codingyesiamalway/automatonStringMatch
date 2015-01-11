/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.*;

/**
 *
 * @author yz473
 */
public class JavaApplication1 {

    public Set<Character> getAlphabet(String hayStack){
        Set<Character> set = new HashSet<>();
        if(hayStack == null){
            return set;
        }else{
            for(int i = 0; i < hayStack.length(); i++){
                set.add(hayStack.charAt(i));
            }
            return set;
        }
    }
    
    public int delta(String p, String x ){
        if(x == null || p == null) return -1;
        else{
            int i = Math.min(x.length(), p.length());
            String comp1 = x.substring(x.length() - i, x.length());
            String comp2 = p.substring(0, i);
            while( !comp1.equals(comp2)){
                i--;
                comp1 = x.substring(x.length() - i, x.length());
                comp2 = p.substring(0, i);
            }
            return i;
        }
    }
    
    public List<Map<Character,Integer>> getTransFunc(String needle, Set<Character> alphabet){
        List<Map<Character,Integer>> transFunc = new ArrayList<>();
        if(needle == null){
            return transFunc;
        }else{
            for(int i = 0; i <= needle.length(); i++){
                Map<Character,Integer> map = new HashMap<>();
                for(char c : alphabet){
                    String Pq = needle.substring(0, i) + c;
                    int nextState = delta(needle, Pq);
                    map.put(c, nextState);
                }
                transFunc.add(map);
            }
            return transFunc;
        }
    }
   
    
    public int strStr(String haystack, String needle) {
        if(haystack == null) return -1;
        else if (needle == null) return 0;
        else{
            Set<Character> set = getAlphabet(haystack);
            List<Map<Character,Integer>> map = getTransFunc(needle, set);
            
            int curState = 0;
            for(int i = 0; i < haystack.length(); i++){
                curState = map.get(curState).get(haystack.charAt(i));
                if (curState == needle.length()){
                    return i - needle.length() + 1;
                }
            }
            return -1;
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s = "abab";
        JavaApplication1 ja = new JavaApplication1();
        Set<Character> set = ja.getAlphabet(s);
        List<Map<Character,Integer>> map = ja.getTransFunc(s, set);
        System.out.println(map);
    }
}
