package resources;

import resources.pages.WizardPage;

public class playGroundForTestingMethods extends WizardPage{

//    @FindBy(xpath = "html/body/div[2]/div[1]/div[2]/div/div[1]/aside/div/p[6]/b")
//    FluentWebElement RequestedEffectiveDate;
//    @Test
//   public void CodingExercise() {
//
////
////        try {
////            System.out.println(saveImagesFromPDF(new URL("file:////Users/sislam13/dev/code/codehub/ole-qa/ole-qa-ui/src/test/java/resources/pdf/full_PDF.pdf")));
////        } catch (MalformedURLException e) {
////            e.printStackTrace();
////        }
//
//        
//        
//        
//    }

    
        String s1, s2;
        public playGroundForTestingMethods() {
            s1 ="Super class";
            s2 ="Parent class";
            System.out.println("Inside the parent no argument constructor");
        }
        public playGroundForTestingMethods(String str) {
            s1= str;
            s2= str;
            System.out.println("Inside the parent parametarized constructor");
        }
    
}
class Boy extends playGroundForTestingMethods {
    public Boy() {
        //super("saiful");
        s2 = "Child class";
        System.out.println("Inside the boy constructor");
    }
    public Boy(String s){
        //super();
        s2=s;
    }
    public Boy(Integer s){
        //super();
        s=0;
    }

    public void disp() {
        System.out.println("String 1 is: " + s1);
        System.out.println("String 2 is: " + s2);
    }
    public void disp(String s) {
        System.out.println("String 1 is: " + s1);
        System.out.println("String 2 is: " + s2);

    }
    public void disp(int s) {
        System.out.println("String 1 is: " + s1);
        System.out.println("String 2 is: " + s2);

    }

    public static void main(String args[]) {
//        Boy obj = new Boy();
//        obj.disp();
        System.out.println(System.getProperty("user.dir")+"/ole-qa-ui/RegressionResults/");


//        /Users/sislam13/dev/code/codehub/ole-qa/ole-qa-ui/RegressionResults
//        /Users/sislam13/dev/code/codehub/ole-qa
    }
}



      

        
    
    
    

