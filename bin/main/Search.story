
Scenario: Search for the Quero adquirir, como devo fazer? on Getnet website
 
Given I navigate to site.getnet.com.br
When I search for "vermelhinha"
Then the text "Perguntas Frequentes – Vermelhinha" is present
When I click the link "Veja Mais"
Then the text "Quero adquirir, como devo fazer?" is present
