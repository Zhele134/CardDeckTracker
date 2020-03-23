# My Personal Project

## Hearthstone Card Maker and Deck Tracker

This application will let the user be able to **make their custom Hearthstone Cards**, as well as **make decks**
with these cards. The user will create cards by first selecting the card type (minion, spell, weapon, etc.), then
adding their stats and properties (attack, health, cost, tribe, etc.). The application will render a picture
of the card based on their stats, emulating the style of Hearthstone cards. These cards will be saved in an overall
database for later use. Finally, the user will be able to create Hearthstone decks from these cards, being able to add 
and remove cards to a deck. These decks will also be saved for future use. 

Any user with an interest in Hearthstone can use this application.

This project is of interest for me because Hearthstone is a game I really enjoy, and drafting up decks with
my card library is a fun aspect of the game for me. In addition, there's a sub-community of Hearthstone I enjoy called
"Custom Hearthstone Cards", where players can draft up ideas for unofficial cards in the game. Making this application 
can make it easier to draft up concepts of these cards, allowing me to contribute more to that community. 



#User Stories

- As a user, I want to be able to select the type of card I'm making before adding its stats
- As a user, I want to be able to add stats to my cards (attack, health, rarity, tribe, cost, etc.)
- As a user, I want to be able to edit these stats to my cards if I want to make changes
- As a user, I want to be able to make decks by adding or removing cards to them
- As a user, I want to see how much these decks will cost to craft (dust value)
- As a user, I want to be able to save my cards, and load them to use again later.
- As a user, I want to be able to save my decks, and load them to edit later. 

#Instructions for Grader

- You can generate the first required event by adding a card to your card library. First, click "Edit Cards", then
"Make a Card". Enter some values into the fields then click "Confirm Stats". Afterwards, go back and click "View Card
Library" and the name of your card should appear within the list.

- You can generate the second required event by removing a card from your deck. First, click "Edit Decks", then
"Load Deck" and select one of the decks. If that doesn't work, add some cards to your deck by clicking "Add Card", 
then typing in the names of some of the cards in the library. Afterwards, you can remove a card by clicking "Remove Card",
where you enter the name of the card you want to remove within the deck. 

- You can trigger my audio component by clicking any button within the application.

- You can save the state of my application by clicking "Save Card Library" in the Card portion, or "Save Deck" in the 
Deck portion.

- You can reload the state of the application in the Deck portion by clicking "Load Deck" and selecting one of the 
Quest Druid Decks. 