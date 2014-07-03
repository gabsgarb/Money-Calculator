package UI;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import moneycalculator.ActionListenerFactory;
import moneycalculator.CurrencyDialog;
import moneycalculator.CurrencyDialogPanel;
import moneycalculator.MoneyViewer;
import moneycalculator.MoneyViewerPanel;

public class ApplicationFrame extends JFrame{
    private MoneyDialog moneyDialog;
    private CurrencyDialog currencyDialog;
    private MoneyViewer moneyViewer;
    private final ActionListenerFactory factory;

    public ApplicationFrame(ActionListenerFactory factory) throws HeadlessException {
        super("Money calculator");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.factory = factory;
        this.setSize(320,320);
        this.setLocationRelativeTo(null);
        this.createComponents();
        this.setVisible(true);
    }

    private void createComponents() {
        this.add(createContentPanel());
        this.add(createToolbarPanel(), BorderLayout.SOUTH);
    }

    private JPanel createContentPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(createCurrencyDialogPanel());
        panel.add(createMoneyViewerPanel());
        panel.add(createMoneyDialogPanel());
        return panel;
    }

    private JPanel createToolbarPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel.add(createCalculateButton());
        panel.add(createExitButton());
        return panel;
    }

    private JButton createCalculateButton() {
        JButton calculate = new JButton ("Calculate");
        this.getRootPane().setDefaultButton(calculate);
        calculate.addActionListener(factory.createActionListener("calculate"));
        return calculate;
    }

    private JButton createExitButton() {
        JButton exit = new JButton ("Exit");
        exit.addActionListener(factory.createActionListener("exit"));
        return exit;
    }

    private JPanel createMoneyDialogPanel() {
        MoneyDialogPanel panel = new MoneyDialogPanel();
        this.moneyDialog = panel;
        return panel;
    }

    private JPanel createCurrencyDialogPanel() {
        CurrencyDialogPanel panel = new CurrencyDialogPanel("USD");
        this.currencyDialog = panel;
        return panel;
    }

    private JPanel createMoneyViewerPanel() {
        MoneyViewerPanel panel = new MoneyViewerPanel();
        this.moneyViewer = panel;
        return panel;
    }

    public MoneyDialog getMoneyDialog() {
        return moneyDialog;
    }

    public CurrencyDialog getCurrencyDialog() {
        return currencyDialog;
    }

    public MoneyViewer getMoneyViewer() {
        return moneyViewer;
    }
    
}
