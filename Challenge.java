  
  
  
  
  
  class Challenge{
  public static String markdownParser(String markdown){ 
   int counter=0; 
   markdown= markdown.trim(); //ignore extra spacing in the given string
   String answer="";
   boolean space= false ; 
   boolean start= true; //to make sure the string starts with a pound sign 
    
for(int i=0; i<markdown.length(); i++){
  //searching through the string for pound signs
  if(markdown.charAt(i)=='#'&& start==true){
   counter++;
  }
  else if(markdown.charAt(i)!= '#'&& start==true){
    start=false;
    if(markdown.charAt(i)==' '){
       space=true; //check if the space is after the pound sign
      
      String header= markdown.substring(counter+1).trim(); 
      //storing the header text, trimmed through trail and error with Lost In Space Test
      answer= "<h"+counter+">"+header+"</h"+counter+">";
    }
  }
}
if(counter==0||counter>6||space==false){
    answer= markdown;
  //check if string is invalid then original string is stored as answer
  }
   
  return answer;
  }

}
