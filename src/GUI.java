import javax.swing.*;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class GUI extends JFrame {
    private JButton addButton, delButton, searchButton, changeButton, luckButton, colorButton;
    private JTable addressTable;
    private JScrollPane scrollPane;
    private TableModel model ;
    private TableRowSorter<TableModel> search;
    private int color = 1;


    public GUI() {
        setSize(640, 480);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Адресная книга");
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.black);
        setLayout(null);

        JRadioButton russian = new JRadioButton("Русский");
        russian.setBackground(null);
        russian.setForeground(Color.red);
        JRadioButton english = new JRadioButton("English");
        russian.setBounds(390, 2, 100, 30);
        russian.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (russian.isSelected()) {
                    english.setSelected(false);
                    addButton.setText("Добавить");
                    delButton.setText("Удалить");
                    colorButton.setText("Цвет");
                    searchButton.setText("Поиск");
                    changeButton.setText("Изменить");
                    luckButton.setText("Мне повезёт!");
                }
                russian.setBackground(null);
                russian.setForeground(Color.red);
                russian.setFont(new Font("Times New Roman", Font.PLAIN, 14));
            }
        });
        getContentPane().add(russian);

        english.setBounds(390, 27, 100, 30);
        english.setBackground(null);
        english.setForeground(Color.red);
        english.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (english.isSelected()) {
                    russian.setSelected(false);
                    addButton.setText("Add");
                    colorButton.setText("Color");
                    delButton.setText("Delete");
                    searchButton.setText("Search");
                    changeButton.setText("Rewrite");
                    luckButton.setText("I'm lucky!");
                }
                english.setBackground(null);
                english.setForeground(Color.red);
                english.setFont(new Font("Times New Roman", Font.PLAIN, 14));
            }
        });
        getContentPane().add(english);


        JLabel mlg = new JLabel();
        mlg.setIcon(new ImageIcon("mlg.png"));
        getContentPane().add(mlg);
        mlg.setBounds(13,3,200,50);

        model = new TableModel();
        addressTable = new JTable(model);
        scrollPane = new JScrollPane(addressTable);
        scrollPane.setBounds(15, 100, 600, 340);
        getContentPane().add(scrollPane);

        Data data = new Data();

        addButton = new JButton("Добавить");
        addButton.setBounds(15, 60, 100, 30);
        addButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        addButton.setBackground(Color.white);
        addButton.setForeground(Color.black);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                data.setVisible(true);
            }
        });
        getContentPane().add(addButton);

        delButton = new JButton("Удалить");
        delButton.setBounds(140, 60, 100, 30 );
        delButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        delButton.setBackground(Color.white);
        delButton.setForeground(Color.black);
        delButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.dataArrayList.remove(addressTable.getSelectedRow());
                JOptionPane.showMessageDialog(null, "Данные стерты");
                addressTable.updateUI();
            }
        });
        getContentPane().add(delButton);

        search = new TableRowSorter<TableModel>(model);
        addressTable.setRowSorter(search);
        searchButton = new JButton("Поиск");
        searchButton.setBounds(514, 60, 100, 30 );
        searchButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        searchButton.setBackground(Color.white);
        searchButton.setForeground(Color.black);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = JOptionPane.showInputDialog(null, "Введите ключевое слово для поиска");
                if (s.length() == 0) {
                    search.setRowFilter(null);
                } else {
                    search.setRowFilter(RowFilter.regexFilter(s));
                }

            }
        });
        getContentPane().add(searchButton);

        luckButton = new JButton("Мне повезёт!");
        luckButton.setBounds(380, 60, 110, 30);
        luckButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        luckButton.setBackground(Color.white);
        luckButton.setForeground(Color.black);
        luckButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Не угадал:)");
                System.exit(0);
            }
        });
        getContentPane().add(luckButton);

        colorButton = new JButton("Цвет");
        colorButton.setBackground(Color.white);
        colorButton.setForeground(Color.black);
        colorButton.setBounds(514,5, 100, 40 );
        colorButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        colorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color+=1;
                switch (color){
                    case 1:
                        getContentPane().setBackground(Color.BLACK);
                        english.setBackground(null);
                        russian.setBackground(null);
                        break;
                    case 2:getContentPane().setBackground(Color.YELLOW);
                        english.setBackground(null);
                        russian.setBackground(null);
                        break;
                    case 3:getContentPane().setBackground(Color.BLUE);
                        english.setBackground(null);
                        russian.setBackground(null);
                        color=0;
                        break;
                }
            }
        });
        getContentPane().add(colorButton);




        changeButton = new JButton("Изменить");
        changeButton.setBounds(265, 60, 100, 30 );
        changeButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        changeButton.setBackground(Color.white);
        changeButton.setForeground(Color.black);
        changeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rewrite rewrite = new Rewrite();
                rewrite.setVisible(true);
                //addressTable.updateUI();
            }
        });

        getContentPane().add(changeButton);

        JLabel langLabel = new JLabel("Язык/Language:");
        langLabel.setBackground(Color.black);
        langLabel.setForeground(Color.red);
        langLabel.setBounds(270, 18, 100, 20);
        getContentPane().add(langLabel);
        langLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));


    }

    class Data extends JFrame {
        Data() {
            setSize(300, 240);
            setLayout(null);
            setResizable(false);
            setLocationRelativeTo(null);
            setTitle("Данные");
            getContentPane().setBackground(Color.black);

            JLabel nameLabel = new JLabel("Введите ФИО:");
            nameLabel.setForeground(Color.white);
            nameLabel.setBounds(20, 16, 200, 30);
            nameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
            getContentPane().add(nameLabel);

            JLabel locationLabel = new JLabel("Введите город:");
            locationLabel.setForeground(Color.white);
            locationLabel.setBounds(20, 48, 200, 30);
            locationLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
            getContentPane().add(locationLabel);

            JLabel subwayLabel = new JLabel("Введите станцию метро:");
            subwayLabel.setForeground(Color.white);
            subwayLabel.setBounds(20, 81, 200, 30);
            subwayLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
            getContentPane().add(subwayLabel);


            JLabel addressLabel = new JLabel("Введите адрес:");
            addressLabel.setForeground(Color.white);
            addressLabel.setBounds(20, 114, 200, 30);
            addressLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
            getContentPane().add(addressLabel);


            JTextField nameText = new JTextField();
            nameText.setBounds(170, 20, 120, 30);
            nameText.setBackground(Color.white);
            nameText.setForeground(Color.black);
            nameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
            getContentPane().add(nameText);

            JTextField locationText = new JTextField();
            locationText.setBounds(170, 50, 120, 30);
            locationText.setBackground(Color.white);
            locationText.setForeground(Color.black);
            locationLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
            getContentPane().add(locationText);

            JTextField subwayText = new JTextField();
            subwayText.setBounds(170, 80, 120, 30);
            subwayText.setBackground(Color.white);
            subwayText.setForeground(Color.black);
            subwayText.setFont(new Font("Times New Roman", Font.PLAIN, 14));
            getContentPane().add(subwayText);

            JTextField addressText = new JTextField();
            addressText.setBounds(170, 110, 120, 30);
            addressText.setBackground(Color.white);
            addressText.setForeground(Color.black);
            addressText.setFont(new Font("Times New Roman", Font.PLAIN, 14));
            getContentPane().add(addressText);


            JButton addButton = new JButton("Добавить");
            addButton.setBackground(Color.white);
            addButton.setForeground(Color.black);
            addButton.setBounds(20, 160, 255, 35);
            addButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String name = nameText.getText();
                    String location = locationText.getText();
                    String subway = subwayText.getText();
                    String address = addressText.getText();
                    if (name.length() == 0 && location.length()==0 && subway.length()==0 && address.length()==0)
                        JOptionPane.showMessageDialog(null, "Вы не заполнили ни одного поля");
                    else {
                        String[] information = {
                                name, location, subway, address
                        };
                        model.addData(information);
                        addressTable.updateUI();
                        JOptionPane.showMessageDialog(null, "Данные успешно добавлены");
                        nameText.setText("");
                        locationText.setText("");
                        subwayText.setText("");
                        addressText.setText("");
                        setVisible(false);
                    }
                }
            });
            getContentPane().add(addButton);
        }

    }

    class Rewrite extends JFrame{
        public JTextField nameText, locationText, subwayText, addressText;
        Rewrite(){
            setSize(300, 240);
            setLayout(null);
            setResizable(false);
            setLocationRelativeTo(null);
            setTitle("Данные");
            getContentPane().setBackground(Color.black);



            JLabel nameLabel = new JLabel("Введите ФИО:");
            nameLabel.setBounds(20, 20, 200, 30);
            nameLabel.setForeground(Color.white);
            nameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
            getContentPane().add(nameLabel);

            JLabel locationLabel = new JLabel("Введите город:");
            locationLabel.setForeground(Color.white);
            locationLabel.setBounds(20, 50, 200, 30);
            locationLabel.setBackground(Color.white);
            locationLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
            getContentPane().add(locationLabel);

            JLabel subwayLabel = new JLabel("Введите станцию метро:");
            subwayLabel.setForeground(Color.white);
            subwayLabel.setBounds(20, 80, 200, 30);
            subwayLabel.setBackground(Color.white);
            subwayLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
            getContentPane().add(subwayLabel);

            JLabel addressLabel = new JLabel("Введите адрес:");
            addressLabel.setForeground(Color.white);
            addressLabel.setBounds(20, 110, 200, 30);
            addressLabel.setBackground(Color.white);
            addressLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
            getContentPane().add(addressLabel);



            JTextField nameText = new JTextField(null);
            nameText.setBounds(170, 20, 120, 30);
            nameText.setBackground(Color.white);
            nameText.setForeground(Color.black);
            nameText.setFont(new Font("Times New Roman", Font.PLAIN, 14));
            getContentPane().add(nameText);

            JTextField locationText = new JTextField();
            locationText.setBounds(170, 50, 120, 30);
            locationText.setBackground(Color.white);
            locationText.setForeground(Color.black);
            locationText.setFont(new Font("Times New Roman", Font.PLAIN, 14));
            getContentPane().add(locationText);

            JTextField subwayText = new JTextField();
            subwayText.setBounds(170, 80, 120, 30);
            subwayText.setBackground(Color.white);
            subwayText.setForeground(Color.black);
            subwayText.setFont(new Font("Times New Roman", Font.PLAIN, 14));
            getContentPane().add(subwayText);

            JTextField addressText = new JTextField();
            addressText.setBounds(170, 110, 120, 30);
            addressText.setBackground(Color.white);
            addressText.setForeground(Color.black);
            addressText.setFont(new Font("Times New Roman", Font.PLAIN, 14));
            getContentPane().add(addressText);

            nameText.setText((String) addressTable.getValueAt(addressTable.getSelectedRow(), 0));
            locationText.setText((String) addressTable.getValueAt(addressTable.getSelectedRow(), 1));
            subwayText.setText((String) addressTable.getValueAt(addressTable.getSelectedRow(), 2));
            addressText.setText((String) addressTable.getValueAt(addressTable.getSelectedRow(), 3));

            JButton saveButton = new JButton("Сохранить");
            saveButton.setBackground(Color.white);
            saveButton.setForeground(Color.black);
            saveButton.setBounds(20, 160, 255, 35);
            saveButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
            saveButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String name = nameText.getText();
                    String location = locationText.getText();
                    String subway = subwayText.getText();
                    String address = addressText.getText();
                    if (name.length() == 0 && location.length()==0 && subway.length()==0 && address.length()==0)
                        JOptionPane.showMessageDialog(null, "Вы не заполнили ни одного поля");
                    else {
                        String[] information = {
                                name, location, subway, address
                        };
                        //model.dataArrayList.remove(addressTable.getSelectedRow());
                        model.dataArrayList.set(addressTable.getSelectedRow(), information);
                        //model.addData(information);
                        addressTable.updateUI();
                        JOptionPane.showMessageDialog(null, "Данные успешно обновлены");
                        nameText.setText("");
                        locationText.setText("");
                        subwayText.setText("");
                        addressText.setText("");
                        setVisible(false);
                    }
                }
            });
            getContentPane().add(saveButton);


        }

    }

    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.setVisible(true);
    }
}