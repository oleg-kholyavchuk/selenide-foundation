Feature: Bot for the website klavogonki

  Background: I am on the main page of the site
    Given Open website "https://klavogonki.ru/go?type=normal"

    Scenario: The bot starts the game and enters the word itself
      When Starting the game
      And Waiting for the game to start
      And Enter the highlighted word
      Then We fix that the game is completed and there are more than 1500 characters per minute