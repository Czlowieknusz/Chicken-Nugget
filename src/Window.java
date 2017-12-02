
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Window extends JFrame {

	private static final long serialVersionUID = 1894037743641945270L;
	static JTextField cattegory, maxprice;
	static JButton button1, button2, boy, girl, ds, find,ebe,age1,age2,age3;
	static JLabel spacer;
	static JComboBox comboBoxSynonyms;
	static JList list;
	static String cattegory_string, max_price, gender_type;
	static PobieranieZInternetu downloadFromInternet = new PobieranieZInternetu();
	static int age;

	Window() {

		JFrame frame = new JFrame("Christmas Bot Henryk!");
        frame.getContentPane().setLayout(new FlowLayout());
        cattegory = new JTextField(45);
        maxprice = new JTextField(45);
        cattegory.setFont(cattegory.getFont().deriveFont(18.0f));
        maxprice.setFont(maxprice.getFont().deriveFont(18.0f));
        
        JLabel label = new JLabel("What would you like to buy? Christmas is coming... Lets find something!");
        label.setFont (label.getFont ().deriveFont (18.0f));
        JLabel mprice = new JLabel("What is your maximum budget?");
        mprice.setFont (mprice.getFont ().deriveFont (18.0f));
        JLabel gender = new JLabel("Does the gender matter??");
        gender.setFont(gender.getFont().deriveFont(18.0f));
        JLabel spac = new JLabel("               ");

        boy = new JButton("Male");
        girl = new JButton("Female");
        ds = new JButton("Doesn't matter");
        find = new JButton("Let's find something together!");
        ebe = new JButton("I have no idea, please help me :(");
        age1 =new JButton("0-10");
        age2 =new JButton("10-20");
        age3 =new JButton("20+");
        
        
    	age1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				age=0;
			}
		});
    	age2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				age=1;
			}
		});
    	age3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				age=2;
			}
		});
        
        
        
		boy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gender_type = "men";
			}
		});
		
		ebe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Item item = new Item(age);
				cattegory_string=item.idea;
			}
		});

		girl.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gender_type = "women";
			}
		});

		ds.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gender_type = "";
			}
		});

		cattegory.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				cattegory_string = cattegory.getText();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				cattegory_string = cattegory.getText();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				cattegory_string = cattegory.getText();
			}
		});

		maxprice.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				max_price = maxprice.getText();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				max_price = maxprice.getText();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				max_price = maxprice.getText();
			}
		});

		find.addActionListener(new ActionListener() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					List<String> synonims = downloadFromInternet.getSynonimsList(cattegory_string);
					synonims.add(cattegory_string);
					if (comboBoxSynonyms == null) {
						comboBoxSynonyms = new JComboBox(synonims.toArray());
						frame.add(spacer = new JLabel("          										          "));
					} else {
						comboBoxSynonyms.removeAllItems();
						for (Object i : synonims.toArray()) {
							comboBoxSynonyms.addItem(i);
						}
					}
					frame.add(comboBoxSynonyms);
					List<String> query = new LinkedList<>();
					query.add((String) comboBoxSynonyms.getSelectedItem());
					query.add(max_price);
					query.add("$");
					if (list == null) {
						list = new JList(downloadFromInternet.getItemsList(query));
					} else {
						list.removeAll();
						DefaultListModel temp = downloadFromInternet.getItemsList(query);
						list.setModel(temp);
					}
					comboBoxSynonyms.addItemListener(new ItemListener() {

						@Override
						public void itemStateChanged(ItemEvent e) {
							DefaultListModel temp;
							try {
								query.clear();
								query.add((String) comboBoxSynonyms.getSelectedItem());
								query.add(max_price);
								query.add("$");
								temp = downloadFromInternet.getItemsList(query);
								list.removeAll();
								list.setModel(temp);
							} catch (IOException | URISyntaxException eka) {
								eka.printStackTrace();
							}
						}
					});
					list.addListSelectionListener(new ListSelectionListener() {
						@Override
						public void valueChanged(ListSelectionEvent e) {
							if (!e.getValueIsAdjusting()) {
								try {

									URI uri = new URI((String) list.getSelectedValue());
									Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
									if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
										desktop.browse(uri);
									}
								} catch (URISyntaxException | IOException ex) {
									Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
								}
							}
						}
					});
					frame.add(list);
					frame.setVisible(true);
				} catch (IOException | URISyntaxException ex) {
					Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		});

		frame.add(label);
		frame.add(ebe);
		frame.add(age1);
		frame.add(age2);
		frame.add(age3);
		frame.getContentPane().add(cattegory);
		frame.add(mprice);
		frame.add(maxprice);
		frame.add(gender);
		frame.add(boy);
		frame.add(girl);
		frame.add(ds);
		frame.add(spac);
		frame.add(find);
		frame.setSize(640, 480);
		frame.setVisible(true);
		frame.setResizable(false);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String args[]) {
		new Window();

	}
}
