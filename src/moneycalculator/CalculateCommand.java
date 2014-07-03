package moneycalculator;

import UI.MoneyDialog;
import Model.Money;

public class CalculateCommand extends Command{

    private final MoneyDialog moneyDialog;
    private final CurrencyDialog currencyDialog;
    private final MoneyViewer moneyViewer;

    public CalculateCommand(MoneyDialog moneyDialog, CurrencyDialog currencyDialog, MoneyViewer moneyViewer) {
        this.moneyDialog = moneyDialog;
        this.currencyDialog = currencyDialog;
        this.moneyViewer = moneyViewer;
    }

    @Override
    public void execute() {
        moneyViewer.show(new Money(calculateAmount(), currencyDialog.getCurrency()));
    }    

    private double getExchangeRate() {
        return 0.6;
    }

    private double calculateAmount() {
        return moneyDialog.getMoney().getAmount() * getExchangeRate();
    }

}
