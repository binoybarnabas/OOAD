# OOAD
##Banking
When a customer tries to make a deposit, a comprehensive list of the customer's existing accounts will be displayed. This enables the customer to choose the specific account into which they wish to deposit funds. The customer may hold various types of accountS like savings max account, current account and loan account.

· Customer(customerCode, customerName, List).
· Account(accountNo, accountType, balance, Product). 
· Product(productCode, productName, List).
· Service(serviceCode, serviceName,rate).
· SavingsMaxAccount is a Product(minimumBalance of Rs.1000 should be maintained in the account). 
· CurrentAccount is a Product.
· LoanAccount is a Product. 
(chequeDeposit should be chargeable ie 3%). 

Default services: SavingsMaxAccount(CashDeposit, ATMWithdrawl, OnlineBanking), CurrentAccount(CashDeposit, OnlineBanking, ATMWithdrawl, MobileBanking), LoanAccount(CashDeposit, ChequeDeposit)

UML diagram(class)
![ooad drawio](https://github.com/binoybarnabas/OOAD/assets/77873811/b9a541ae-5ae3-466c-8058-4c7b5c9aee06)
