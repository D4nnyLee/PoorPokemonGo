import java.awt.*;
import java.util.*;

import javax.swing.*;
import javax.swing.plaf.basic.DefaultMenuLayout;

public class Store extends JPanel
{
    private Hashtable<String, Product> productList;
    private Status user;
    private JLabel remainMoney;
    private JButton exitButton;

    public Store()
    {
        productList = new Hashtable<String, Product>();
        productList.put("leg", new Product("leg", 50, this));
        productList.put("coffee", new Product("coffee", 50, this));
        productList.put("G_test", new Product("G_test", 50, this));

        productList.put("ticket", new Product("ticket", 200, this));
        productList.put("redblue", new Product("redblue", 200, this));
        productList.put("underwear", new Product("underwear", 200, this));

        productList.put("medician", new Product("medician", 300, this));
        productList.put("phone", new Product("phone", 300, this));
        productList.put("mask", new Product("mask", 300, this));
        productList.put("H_test", new Product("H_test", 300, this));

        remainMoney = new JLabel("0");
        exitButton = new JButton("Exit");

        formProperLayout();

        setVisible(false);
    }

    /**
     * This method should called when clicking the lunch
     * buttom of store.
     * @user The status of user
     */
    public void init(Status user)
    {
        this.user = user;
        setVisible(true);
    }

    /**
     * This method should be called when exiting the store.
     */
    public Status exit()
    {
        setVisible(false);
        return user;
    }

    public void buy(Product p, Integer n)
    {
        // if (n * p.getPrice() > user.money)
        //     return;

        user.money -= n * p.getPrice();
        remainMoney.setText(String.valueOf(user.money));
        /* TODO: add skill to user's skill list */
    }

    private void formProperLayout()
    {
        JLabel l = new JLabel("Money:");
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);

        /* Horizontal */
        GroupLayout.ParallelGroup hg1 = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
        hg1.addComponent(productList.get("leg"));
        hg1.addComponent(productList.get("ticket"));
        hg1.addComponent(productList.get("phone"));

        GroupLayout.ParallelGroup hg2 = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
        hg2.addComponent(productList.get("coffee"));
        hg2.addComponent(productList.get("redblue"));
        hg2.addComponent(productList.get("medician"));

        GroupLayout.ParallelGroup hg3 = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
        hg3.addComponent(productList.get("G_test"));
        hg3.addComponent(productList.get("underwear"));
        hg3.addComponent(productList.get("H_test"));

        GroupLayout.ParallelGroup hg4 = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
        hg4.addComponent(productList.get("mask"));

        GroupLayout.ParallelGroup hg5 = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
        hg5.addGroup(layout.createSequentialGroup().addComponent(l).addComponent(remainMoney));
        hg5.addComponent(exitButton);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                                          .addGroup(hg1)
                                          .addGroup(hg2)
                                          .addGroup(hg3)
                                          .addGroup(hg4)
                                          .addGroup(hg5));

        /* Vertical */
        GroupLayout.ParallelGroup vg1 = layout.createParallelGroup(GroupLayout.Alignment.CENTER);
        vg1.addComponent(productList.get("leg"));
        vg1.addComponent(productList.get("coffee"));
        vg1.addComponent(productList.get("G_test"));
        vg1.addComponent(l);
        vg1.addComponent(remainMoney);

        GroupLayout.ParallelGroup vg2 = layout.createParallelGroup(GroupLayout.Alignment.CENTER);
        vg2.addComponent(productList.get("ticket"));
        vg2.addComponent(productList.get("redblue"));
        vg2.addComponent(productList.get("underwear"));

        GroupLayout.ParallelGroup vg3 = layout.createParallelGroup(GroupLayout.Alignment.CENTER);
        vg3.addComponent(productList.get("phone"));
        vg3.addComponent(productList.get("medician"));
        vg3.addComponent(productList.get("H_test"));
        vg3.addComponent(productList.get("mask"));
        vg3.addComponent(exitButton);

        layout.setVerticalGroup(
                layout.createSequentialGroup().addGroup(vg1).addGroup(vg2).addGroup(vg3));
    }

    public static void main(String[] args)
    {
        JFrame f = new JFrame("123");
        Store st = new Store();
        st.init(new Status());

        f.add(st);
        // f.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        f.pack();
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
