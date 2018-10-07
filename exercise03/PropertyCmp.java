/**  
* Title: PropertyCmp.java 
* Description: list,set,map的查找速度测试
* @author Yjj  
* @date 2018年10月6日 下午8:38:54
* @version 1.0  
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

import java.util.HashSet;
import java.util.TreeSet;

import java.util.HashMap;
import java.util.TreeMap;

import java.util.Random;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.lang.String;

class Timeclac{
	Random  r = new Random();
	/**
	* 随机存储10000个不重复数放入容器，返回从中搜索一个任意数所花的时间
	*
	* @param times 搜索的次数，越大越精确，同时也会占用更多的时间
	* @return (end-starts)/times 平均计算后搜索一次花的时间
	*/
	public long getArrayListTime(int times) {	
		List<Integer> list = new ArrayList<Integer>();
        int i;
        while(list.size() < 10000){
            i = r.nextInt(10000);
            if(!list.contains(i)){
                list.add(i);
            }
        }
        
        long start=System.nanoTime(); //获取开始时间
        for(int x=0;x<times;x++)
        	list.contains(r.nextInt(10000));
        long end=System.nanoTime(); //获取结束时间
      
	    return (end-start)/times;
	}
	
	public long getLinkedListTime(int times) {
		List<Integer> list = new LinkedList<Integer>();
        int i;
        while(list.size() < 10000){
            i = r.nextInt(10000);
            if(!list.contains(i)){
                list.add(i);
            }
        }
        
        long start=System.nanoTime(); //获取开始时间
        for(int x=0;x<times;x++)
        	list.contains(r.nextInt(10000));
        long end=System.nanoTime(); //获取结束时间
      
	    return (end-start)/times;  
	}
	
	public long getVectorTime(int times) {
		List<Integer> list = new Vector<Integer>();
        int i;
        while(list.size() < 10000){
            i = r.nextInt(10000);
            if(!list.contains(i)){
                list.add(i);
            }
        }
        
        long start=System.nanoTime(); //获取开始时间
        for(int x=0;x<times;x++)
        	list.contains(r.nextInt(10000));
        long end=System.nanoTime(); //获取结束时间
      
	    return (end-start)/times;  
	}
	
	public long getHashSetTime(int times) {
		HashSet<Integer> hash = new HashSet<Integer>();
        int i;
        while(hash.size() < 10000){
            i = r.nextInt(10000);
            if(!hash.contains(i)){
                hash.add(i);
            }
        }
        
        long start=System.nanoTime(); //获取开始时间
        for(int x=0;x<times;x++)
        	hash.contains(r.nextInt(10000));
        long end=System.nanoTime(); //获取结束时间
      
	    return (end-start)/times;   
	}
	
	public long getTreeSetTime(int times) {
		TreeSet<Integer> tree = new TreeSet<Integer>();
        int i;
        while(tree.size() < 10000){
            i = r.nextInt(10000);
            if(!tree.contains(i)){
                tree.add(i);
            }
        }
        
        long start=System.nanoTime(); //获取开始时间
        for(int x=0;x<times;x++)
        	tree.contains(r.nextInt(10000));
        long end=System.nanoTime(); //获取结束时间
      
	    return (end-start)/times;   
	}
	
	public long getHashMapTime(int times) {
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int i;
        for(int j=0; map.size() < 10000; j++){
            i = r.nextInt(10000);
            if(!map.containsValue(i)){
                map.put(j,i);
            }
        }
        
        long start=System.nanoTime(); //获取开始时间
        for(int x=0;x<times;x++)
        	map.containsValue(r.nextInt(10000));
        long end=System.nanoTime(); //获取结束时间
      
	    return (end-start)/times;    
	}
	
	public long getTreeMapTime(int times) {
		TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
        int i;
        for(int j=0; map.size() < 10000; j++){
            i = r.nextInt(10000);
            if(!map.containsValue(i)){
                map.put(j,i);
            }
        }
        
        long start=System.nanoTime(); //获取开始时间
        for(int x=0;x<times;x++)
        	map.containsValue(r.nextInt(10000));
        long end=System.nanoTime(); //获取结束时间
      
	    return (end-start)/times;    
	}
}

public class PropertyCmp {
	public static void main(String[] args) {
		Timeclac demo = new Timeclac();

		// 经测试200个数据求平均时的误差较小
		System.out.println("ArrayList:"+demo.getArrayListTime(200)+" ns");
		System.out.println("LinkedList:"+demo.getLinkedListTime(200)+" ns");
		System.out.println("Vector:"+demo.getVectorTime(200)+" ns");
		System.out.println("HashSet:"+demo.getHashSetTime(200)+" ns");
		System.out.println("TreeSet:"+demo.getTreeSetTime(200)+" ns");
		// containsValue查询的时间
		System.out.println("HashMap:"+demo.getHashMapTime(200)+" ns");
		System.out.println("TreeMap:"+demo.getTreeMapTime(200)+" ns");	
		// 键值对get查询的时间
		System.out.println();
		System.out.println("HashMap:"+hashTime(200,"HashMap")+" ns");
		System.out.println("TreeMap:"+hashTime(200,"TreeMap")+" ns");

	}
	public static long hashTime(int times,String type) {
		Random  r = new Random();
		Map<Integer,Integer> map;
		// Issue:if (boolean) 后面不使用花括号时，里面不能出现声明语句!
		if (type.equals("HashMap")){
			map = new HashMap<Integer,Integer>();
		}
		else if(type.equals("TreeMap")){
			 map = new TreeMap<Integer,Integer>();
		}
		else
			return 0;
        int i;
        for(int j=0; map.size() < 10000; j++){
            i = r.nextInt(10000);
            if(!map.containsValue(i)){
                map.put(j,i);
            }
        }      
        long start=System.nanoTime(); //获取开始时间
        for(int x=0;x<times;x++)
        	map.get(r.nextInt(10000));
        long end=System.nanoTime(); //获取结束时间
      
	    return (end-start)/times;
	}
}
