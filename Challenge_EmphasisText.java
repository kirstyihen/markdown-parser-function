class Challenge{
  public static String markdownParser(String markdown){ 
   int counter=0; 
   markdown= markdown.trim(); //ignore extra spacing in the given string
   String answer="";
   boolean space= false ; 
   boolean start= true;//to make sure the string starts with a pound sign 
   
   boolean openingTag=true;
   boolean closingTag=false;
   boolean spaceAfterStar= false;
   int stars=0;
   String markup= markdown;//perhaps unnecessary,but I wanted an unedited version of the markdown
     
for(int i=0; i<markdown.length(); i++){
  //searching through the string for pound signs
  if(markdown.charAt(i)=='#'&& start==true){
   counter++;
  }
  else if(markdown.charAt(i)!= '#'&& start==true){
    start=false; //indicates that we are past the first hash
    if(markdown.charAt(i)==' '){
       space=true; //check if the space is after the pound sign
     }
     for(int n=0; n<markdown.length(); n++){
       //now searching for stars
         if(markdown.charAt(n)=='*'&& openingTag==true){
            if(markdown.charAt(n+1)==' '&& n<markdown.length()-1){
              //to catch if there is a space after the star
               return markup;
               }  
             stars++;
             markdown= markdown.replaceFirst("\\*","<em>");
             openingTag=false;
             closingTag=true;
           //toggling between the tags in order to replace the stars with the correct tag
          }
 
          if(markdown.charAt(n)=='*'&& stars>0&& closingTag==true){
             stars++;
             markdown= markdown.replaceFirst("\\*","</em>");
             closingTag=false;
             openingTag=true; 
           }
           if(stars==1&&n==markdown.length()-1){
              return markup;
             //to catch if the markdown has an invalid number of stars
           }
           if(markdown.endsWith(" *")&&n<markdown.length()-1){
             return markup;
             //to catch if there is illegal space before the star
            }
         answer=markdown.trim(); 
        }
           
      String header= markdown.substring(counter+1).trim(); 
      //storing the header text, trimmed through trail and error with Lost In Space Test
      answer= "<h"+counter+">"+header+"</h"+counter+">";
    }
  }  
if(counter==0||counter>6||space==false){
    answer= markdown;
  //check if string is invalid then original string is stored as answer
 }
   
 return answer;
 } 
}
