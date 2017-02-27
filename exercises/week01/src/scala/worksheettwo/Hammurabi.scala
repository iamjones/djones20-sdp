import com.sun.org.apache.bcel.internal.generic.POP

import scala.io.StdIn
import scala.util.Random

object Hammurabi {

    def hammurabi() {

        var starved = 0 // how many people starved
        var immigrants = 5 // how many people came to the city
        var population = 100
        var harvest = 3000 // total bushels harvested
        var bushelsPerAcre = 3 // amount harvested for each acre planted
        var rats_ate = 200 // bushels destroyed by rats
        var bushelsInStorage = 2800
        var acresOwned = 1000
        var pricePerAcre = 19 // each acre costs this many bushels
        var plagueDeaths = 0

        printIntroductoryMessage()

        (1 to 10) foreach { year =>

            // How many acres of land to buy
            var acresToBuy = askHowMuchLandToBuy(bushelsInStorage, pricePerAcre)
            acresOwned = acresOwned + acresToBuy

            // How many acres of land to sell
            if (acresToBuy == 0) {
                acresOwned = acresOwned - askHowMuchLandToSell(acresOwned)
            }

            // How much grain to feed to the people
            var grainToFeedThePeople = askHowMuchGrainToFeedThePeople(bushelsInStorage)
            bushelsInStorage = bushelsInStorage - grainToFeedThePeople

            // How many acres to plant with seed
            var acresToPlant = askHowManyAcresToPlantWithSeed(acresOwned)
            acresOwned = acresOwned - acresToPlant

            // If there is a plague
            if (isThereAPlague) {
                population = population / 2
            }

            // How many people starved
            val peopleWhoGetToEat = grainToFeedThePeople / 20
            if (removedFromPowerDueToStarvation(peopleWhoGetToEat, population)) {
                println("Over 45% of the population has starved. You were killed in a mutiny.")
                return
            }

            // How many people came to the city
            population = population + peopleEnterTheCity(acresOwned, bushelsInStorage, population)

            // How good the harvest is
            bushelsInStorage = bushelsInStorage + producedInHarvest(acresToPlant)

            // If you have a problem with rats
            bushelsInStorage = bushelsInStorage - grainEatenByRats(bushelsInStorage)

            // How much land will cost next year
            pricePerAcre = costOfLand

            println("O great Hammurabi!\n"
            + s"You are in year $year of your ten year rule.\n"
            + s"In the previous year $starved people starved to death.\n"
            + s"In the previous year $immigrants people entered the kingdom.\n"
            + s"The population is now $population.\n"
            + s"We harvested $harvest bushels at $bushelsPerAcre bushels per acre.\n"
            + s"Rats destroyed $rats_ate bushels, leaving $bushelsInStorage bushels in storage.\n"
            + s"The city owns $acresOwned acres of land.\n"
            + s"Land is currently worth $pricePerAcre bushels per acre.\n"
            + s"There were $plagueDeaths deaths from the plague.\n")
        }

        println("Congratulations you lasted 10 years!")
        println("Your final stats are:")

        println(s"In the previous year $starved people starved to death.\n"
            + s"In the previous year $immigrants people entered the kingdom.\n"
            + s"The population is now $population.\n"
            + s"We harvested $harvest bushels at $bushelsPerAcre bushels per acre.\n"
            + s"Rats destroyed $rats_ate bushels, leaving $bushelsInStorage bushels in storage.\n"
            + s"The city owns $acresOwned acres of land.\n"
            + s"Land is currently worth $pricePerAcre bushels per acre.\n"
            + s"There were $plagueDeaths deaths from the plague.\n")
    }

    def printIntroductoryMessage() {
        println("""
        Congratulations, you are the newest ruler of ancient Samaria, elected
        for a ten year term of office. Your duties are to dispense food, direct
        farming, and buy and sell land as needed to support your people. Watch
        out for rat infestations and the plague! Grain is the general currency,
        measured in bushels. The following will help you in your decisions:

            * Each person needs at least 20 bushels of grain per year to survive.
            * Each person can farm at most 10 acres of land.
            * It takes 2 bushels of grain to farm an acre of land.
            * The market price for land fluctuates yearly.

        Rule wisely and you will be showered with appreciation at the end of
        your term. Rule poorly and you will be kicked out of office!""")
    }

    def readInt(message: String): Int = {
        try {
            println(message)
            StdIn.readInt()
        } catch {
            case _: Throwable =>
                println("That’s not an integer. Please enter an integer.")
                readInt(message)
        }
    }

    def askHowMuchLandToBuy(bushels: Int, price: Int) : Int = {
        var acresToBuy = readInt("How many acres will you buy?")
        while (acresToBuy < 0 || acresToBuy * price > bushels) {
            println("O Great Hammurabi, we have but " + bushels + " bushels of grain!")
            acresToBuy = readInt("How many acres will you buy?")
        }
        acresToBuy
    }

    def askHowMuchLandToSell(acresOwned : Int) : Int = {
        var acresToSell = readInt("How many acres will you sell?")
        while (acresOwned < acresToSell) {
            println(s"O Great Hammurabi, we have but we only have $acresOwned acres to sell")
            acresToSell = readInt("How many acres will you buy?")
        }
        acresToSell
    }

    def askHowMuchGrainToFeedThePeople(bushelsInStorage: Int): Int = {
        var grainToFeedThePeople = readInt("How much grain to feed to the people?")
        while (bushelsInStorage < grainToFeedThePeople) {
            println(s"O Great Hammurabi, we have but we only have $bushelsInStorage bushels of grain in storage")
            grainToFeedThePeople = readInt("How much grain to feed to the people?")
        }
        grainToFeedThePeople
    }

    def askHowManyAcresToPlantWithSeed(acresOwned : Int) : Int = {
        var acresToPlant = readInt("How many acres to plant with seed?")
        while (acresOwned < acresToPlant) {
            println(s"O Great Hammurabi, we have but we only have $acresOwned acres to plant in")
            acresToPlant = readInt("How many acres to plant with seed?")
        }
        acresToPlant
    }

    def isThereAPlague : Boolean = {
        Random.nextInt(100) < 15
    }

    def peopleEnterTheCity(acres : Int, grainInStorage : Int, population : Int) : Int = {
        (20 * acres + grainInStorage) / (100 * population) + 1
    }

    def removedFromPowerDueToStarvation(peopleWhoGetToEat : Int, population : Int) : Boolean = {
        peopleWhoGetToEat == 0 || (population / peopleWhoGetToEat) * 100 < 45
    }

    def producedInHarvest(acresPlanted : Int) : Int = {
        acresPlanted * Random.nextInt(8)+1
    }

    def grainEatenByRats(totalGrain : Int) : Int = {
        if (Random.nextInt(100) < 40) {
            (totalGrain / 100) * Random.nextInt(3)+1
        }
        0
    }

    def costOfLand : Int = {
        17 + Random.nextInt(5)
    }
}

Hammurabi.hammurabi()


