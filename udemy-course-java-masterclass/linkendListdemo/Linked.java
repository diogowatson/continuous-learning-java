import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Linked {
    public static void main(String[] args){
        LinkedList<String> placesToVisit = new LinkedList<String>();//create a new linked list object
        //add values to the placesToVisit object using the addiiOrder method
        addinOrder(placesToVisit, "Rio de janeiro");
        addinOrder(placesToVisit, "Minas gerais");
        addinOrder(placesToVisit, "São paulo");
        addinOrder(placesToVisit, "Curitiba");
        addinOrder(placesToVisit, "Florienópolis");
        addinOrder(placesToVisit, "Porto alegre");
        addinOrder(placesToVisit, "Guaporé");
        addinOrder(placesToVisit, "Guaporé");//an repeated insert to make sure validation is working

        printList(placesToVisit);//call the printlist method to print placesToVisit
        //the result is to create a list of places to visit based on alphabetic order (not the best way to make travel plans I guess)
    }

    private static void printList(LinkedList<String> linkedList){//method to interate the linked list and print its values
        Iterator<String> i = linkedList.iterator();//create interator
        while(i.hasNext()){//while the interator has a next value
            System.out.println("Now visiting "+i.next());
        }
        System.out.println("*******************");//to indicates the end of the print
    }
    //this methos was done for study purpouses, in ideal you should not change something and return a value
    private static boolean addinOrder(LinkedList<String> linkList, String newCity){
        ListIterator<String> stringListIterator = linkList.listIterator();//create a interator

        while(stringListIterator.hasNext()){//while it has a nexta value
            int comparison = stringListIterator.next().compareTo(newCity);//compare the next interated value to newCity value
            if(comparison == 0){//mean it already has a similiar value on the list
                System.out.println(newCity + " is already included as destination");
                return false;

            }else if(comparison>0){//
                stringListIterator.previous();//go to the previous likend link

                stringListIterator.add(newCity);
                return true;
            }else if(comparison<0){
                //nothing to to do since sinde hasnext is in the wile loop
            }

        }
        stringListIterator.add(newCity);
        return true;
    }
}
