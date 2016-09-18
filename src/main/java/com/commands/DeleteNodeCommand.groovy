package com.commands


import com.main.Base
import com.main.Network


/**
 * Created by robertobrien on 14/09/2016.
 */
public class DeleteNodeCommand extends Base implements Command {


    def execute() {
        node()
    }


    def node() {

        listCarriers()
        def carrierName = input('Enter the carriers name: ')
        doesCarrierExist(carrierName) ? hub(carrierName) : notExists(carrierName)
    }


    def hub(String carrierName) {

        listHubs(carrierName)
        def hubName = input('Enter the hubs name: ')
        doesHubExist(carrierName, hubName) ? nodeNext(carrierName, hubName) : notExists(hubName)
    }


    def nodeNext(String carrierName, String hubName) {

        listNodes(carrierName, hubName)
        def nodeName = input('Which node would you like to delete?: ')
        doesNodeExist(carrierName, hubName, nodeName) ? deleteNode(carrierName, hubName, nodeName) : notExists(carrierName)
    }


    def deleteNode(String carrier, String hub, String nodeToDelete) {
        Network.carrierMap.get(carrier).hubs.get(hub).nodes.remove(nodeToDelete)
        println "$nodeToDelete deleted"

    }
}