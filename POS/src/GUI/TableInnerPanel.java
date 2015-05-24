package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import GUIData.GUIdata;
import controler.PosFileControler;
import model.PosData;
import model.Table;

public class TableInnerPanel extends JPanel implements ActionListener{

        private TableListPanel tableListPanel;

        private JButton addButton;
        private JButton delButton;
        private JLabel tableText;
        private LineBorder lineBorder;
        private int tableNum;
        private PosData data;

        private SimpleJFrame checkPage; // ÁøÂ¥ »èÁ¦ ÇÒ °Å¾ß?
        private JButton ok; // »èÁ¦ÇÑ´Ù
        private JButton cancel; // »èÁ¦ÇÏÁö ¾Ê´Â´Ù

        public TableListPanel getTableListPanel() {
                return tableListPanel;
        }

        public void setTableListPanel(TableListPanel tableListPanel) {
                this.tableListPanel = tableListPanel;
        }
        public PosData getData() {
                return data;
        }

        public void setData(PosData data) {
                this.data = data;
        }

        public int getTableNum() {
                return tableNum;
        }

        public void setTableNum(int tableNum) {
                this.tableNum = tableNum;
        }

        public TableInnerPanel(PosData data, MenuInnerPanel menuInnerPanel) {

                setData(data);

                lineBorder = new LineBorder(Color.BLACK, 3);
                this.setLayout(null);
                this.setBorder(GUIdata.buttonBorder2);
                this.setBackground(GUIdata.tableInnerPanelColor);
                this.setBounds(30, 80, 800, 680);

                tableListPanel = new TableListPanel(getData(), menuInnerPanel);

                this.add(tableListPanel);



                addButton = new JButton();
                lineBorder = new LineBorder(Color.BLACK, 3);
                addButton.setContentAreaFilled(false);
                addButton.setIcon(new ImageIcon("img/plus_button.png"));
                addButton.setPressedIcon(new ImageIcon("img/plus_button_pressed.png"));
                addButton.setBackground(null);
                addButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
                addButton.setBorder(null);
                addButton.setForeground(Color.white);
                addButton.addActionListener(this);
                addButton.setFocusPainted(false);
                this.add(addButton).setBounds(120, 10, 30, 30);
                //


                // cancel button setup
                delButton = new JButton();
                lineBorder = new LineBorder(Color.BLACK, 3);
                delButton.setContentAreaFilled(false);
                delButton.setIcon(new ImageIcon("img/minus_button.png"));
                delButton.setPressedIcon(new ImageIcon("img/minus_button_pressed.png"));
                delButton.setBackground(null);
                delButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
                delButton.setBorder(null);
                delButton.setForeground(Color.white);
                delButton.addActionListener(this);
                delButton.setFocusPainted(false);
                this.add(delButton).setBounds(170, 10, 30, 30);

                tableText = new JLabel("Table");
                tableText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 30));
                tableText.setForeground(new Color(70, 70, 70));
                this.add(tableText).setBounds(20, 8, 100, 30);
        }


        public void showCheckPage()
        {
                checkPage = new SimpleJFrame("CheckPage", 400, 300);

                lineBorder = new LineBorder(Color.BLACK, 3);

                checkPage.getRootPane().setBorder(lineBorder);
                checkPage.setAlwaysOnTop(true);
                
                JLabel textLabel = new JLabel("Á¤¸» Å×ÀÌºí " + (Table.getSelectedTable() + 1) + "À» »èÁ¦ÇÏ½Ã°Ú½À´Ï±î?");
                textLabel.setBackground(Color.WHITE);
                textLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
                textLabel.setBorder(null);

                ok = new JButton(" »è Á¦ ");
                ok.setBackground(Color.WHITE);
                ok.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
                ok.setBorder(lineBorder);
                ok.addActionListener(this);

                cancel = new JButton(" Ãë ¼Ò ");
                cancel.setBackground(Color.WHITE);
                cancel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
                cancel.setBorder(lineBorder);
                cancel.addActionListener(this);


                checkPage.add(ok).setBounds(50, 200, 100, 50);
                checkPage.add(cancel).setBounds(250, 200, 100, 50);
                checkPage.add(textLabel).setBounds(60, 90, 300, 50);
        }


        @Override
        public void actionPerformed(ActionEvent e) {

                if(e.getSource() == addButton && POSPage.isOnTableCalculateFrame() == false)
                {
                        System.out.println("addTable button clicked");
                        tableListPanel.addTableList();

                        setData(tableListPanel.getData());
                        PosFileControler posFileControler = new PosFileControler(getData());
                        posFileControler.writeToFile();

                }
                else if(e.getSource() == delButton && POSPage.isOnTableCalculateFrame() == false)
                {
                	if(POSPage.isOnResetFrame() == false)
                	{
                		POSPage.setOnResetFrame(true);
                        System.out.println("delTable button clicked");

                        showCheckPage();
                	}
                }
                else if(e.getSource() == ok)
                {
                	POSPage.setOnResetFrame(false);
                        tableListPanel.delTable(Table.getSelectedTable());

                        setData(tableListPanel.getData());
                        PosFileControler posFileControler = new PosFileControler(getData());
                        posFileControler.writeToFile();

                        checkPage.dispose();
                }
                else if(e.getSource() == cancel)
                {
                	POSPage.setOnResetFrame(false);
                        checkPage.dispose();
                }
                // TODO Auto-generated method stub

        }


}