package com.commands;


import com.main.Hub;
import com.main.Network;

import java.util.Scanner;

public class SuggestedRemediesCommand implements Command{

    private Scanner scan = new Scanner(System.in);


    public void execute(){

        System.out.println("");

        ListElements.listCarriers();

        String carrierName;
        do {
            System.out.print("Choose a carrier: ");
            carrierName = scan.nextLine();if(!Network.carrierMap.containsKey(carrierName)){
                System.out.println("No such carrier");
            }

        } while (!Network.carrierMap.containsKey(carrierName));


        String hubOrNodeRemedy;

        System.out.println("");
        System.out.print("Would you like to view remedies for a hub or node?: ");
        hubOrNodeRemedy = scan.nextLine();



        if(hubOrNodeRemedy.equalsIgnoreCase("hub")){

            hubRemedies(carrierName);

        }else if(hubOrNodeRemedy.equalsIgnoreCase("node"))
        {
            nodeRemedies(carrierName);
        }else{
            System.out.println("");
            System.out.print("invalid input");
        }

    }


       private void hubRemedies(String carrierName){

           System.out.println("");

           String hubName;
           Hub hub = new Hub();


           ListElements.listHubs(carrierName);

           do {
               System.out.print("Choose a hub: ");
               hubName = scan.nextLine();
               if(!Network.carrierMap.get(carrierName).hubs.containsKey(hub)){
                   System.out.println("No such hub");
               }
           } while (!Network.carrierMap.get(carrierName).hubs.containsKey(hubName));



           for(int i = 0; i < Network.carrierMap.get(carrierName).hubs.get(hubName).hubAlarms.size(); i++)
           {
               System.out.println("");
               System.out.println("Alarm: " + Network.carrierMap.get(carrierName).hubs.get(hubName).hubAlarms.get(i).getAlarmType() + "\n" +
                                  "Remedy: " + Network.carrierMap.get(carrierName).hubs.get(hubName).hubAlarms.get(i).getAlarmRemedy());
           }
      }




       private void nodeRemedies(String carrierName){

           System.out.println("");

           String hubName;


           ListElements.listHubs(carrierName);

           do {
               System.out.print("Choose a hub: ");
               hubName = scan.nextLine();
           } while (!Network.carrierMap.get(carrierName).hubs.containsKey(hubName));


           String nodeName;


           ListElements.listNodes(carrierName, hubName);

           do {
               System.out.println("");
               System.out.print("Choose a node: ");
               nodeName = scan.nextLine();
           } while (!Network.carrierMap.get(carrierName).hubs.get(hubName).nodes.containsKey(nodeName));


           for(int i = 0; i < Network.carrierMap.get(carrierName).hubs.get(hubName).hubAlarms.size(); i++)
           {
               System.out.println("");
               System.out.println("Alarm: " + Network.carrierMap.get(carrierName).hubs.get(hubName).nodes.get(nodeName).nodeAlarms.get(i).getAlarmType() + "\n" +
                                  "Remedy: " + Network.carrierMap.get(carrierName).hubs.get(hubName).nodes.get(nodeName).nodeAlarms.get(i).getAlarmRemedy());
           }

       }
}
