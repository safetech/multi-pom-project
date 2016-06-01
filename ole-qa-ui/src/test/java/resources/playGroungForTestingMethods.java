package resources;
import org.junit.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class playGroungForTestingMethods {


    @Test
   public void CodingExercise() {
//        List<String> s1 = new ArrayList<String>();
//        s1.add("Joe");
//        s1.add("Kapil");
//        s1.add("danush");
//
//        List<String> s2 = Arrays.asList("Joe", "Kapil", "Sunil","hjgjghjgj");
////
//        if (s1.get(0).equals(s2.get(0))) {
//            System.out.print(s1.get(0));
//        }
//

//
//        int i = 0;
//        int j = 0;
//        while (i < s1.size() && j < s2.size()) {
//
//            if (s1.get(i).equals(s2.get(j))) {
//                System.out.print(s1.get(i));
//            } else
//                System.out.print(s2.get(j)+s1.get(i));
//            i++;
//            j++;
//        }


        List<String> arrayList1= Arrays.asList("Joe", "kapil","danush");
        List<String> arrayList2 = Arrays.asList("Joe", "kapil","Sunil");
        
        List<String> commonElements = new ArrayList<String>(arrayList1);
        commonElements.retainAll(arrayList2);
        System.out.println("common elements -> "+commonElements);
        
        List<String> uniqueElementsInFirstList = new ArrayList<String>(arrayList1);
        uniqueElementsInFirstList.removeAll(arrayList2);
        System.out.println("unique elements in first list ->"+ uniqueElementsInFirstList);
        
    }
}
            

        
        

        
    
    
    

