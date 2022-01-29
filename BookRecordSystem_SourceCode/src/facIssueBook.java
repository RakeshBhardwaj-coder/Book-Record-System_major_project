/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rakeshpc
 */
import java.awt.Color;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class facIssueBook extends javax.swing.JFrame {

    public facIssueBook() {

        initComponents();
//        getIssuName.setVisible(false);
        loadFacIssuedData();
        loadBookData();
        setExtendedState(JFrame.MAXIMIZED_BOTH); //miximize automatically
        setAllColors();
        setInvisible();
//        addBookPanel.setVisible(false);
    }

    /**
     * Creates new form IssueBook
     */
    Color darkBalck = new Color(0, 0, 0);
    Color headerColor = new Color(44, 45, 45);
    Color menuPanelColor = new Color(60, 60, 60);
    Color hoverColor = new Color(58, 58, 58);  //rgba(58,58,58,255)
    Color tableSelectionColor = new Color(55, 55, 55);

    boolean a = true;
    int mousepX, mousepY;

    public void setInvisible() {
        getIssuName.setVisible(false);
        facIssuId.setVisible(false);
        tabpane.setVisible(false);
        bookId.setVisible(false);

    }

    public void setAllColors() {
        headerPanel.setBackground(headerColor);
        AllIcons.setBackground(menuPanelColor);
        bookRecordsTable.setSelectionBackground(tableSelectionColor);
        facBookIssedTable.setSelectionBackground(tableSelectionColor);

    }

    public void changeImage(JLabel button, String resourcesImg) {
        ImageIcon aimg = new ImageIcon(getClass().getResource(resourcesImg));
        button.setIcon(aimg);

    }

    public void changeColor(JPanel hover, Color rand) {
        hover.setBackground(rand);
    }

    String getIssueName;
    public int bookAvailable;

    public void bookAvailable() {
        bookAvailable = Integer.parseInt(this.bookCount.getText());

//            bookAvailiblity = Integer.parseInt(res2.getString("b_count"));
    }

    public void loadBookData() {

        Connection con2;
        Statement stmt2;
        ResultSet res2;
        String qry2;
        DefaultTableModel dtm2;
        int sno2 = 1;

        try {
            con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_Book_Record_System", "root", "");
            stmt2 = con2.createStatement();
            qry2 = "Select * from db_Book";
            res2 = stmt2.executeQuery(qry2);

//            bookAvailiblity = Integer.parseInt(res2.getString("b_count"));
//            
//            this.bookAvail.setText("Book Availiblity : "+bookAvailiblity);
            Object[] bookRecords = new Object[7];

            dtm2 = (DefaultTableModel) bookRecordsTable.getModel();
            dtm2.setRowCount(0);

            while (res2.next()) {
                bookRecords[0] = sno2;
                bookRecords[1] = res2.getInt("b_id");
                bookRecords[2] = res2.getString("b_name");
                bookRecords[3] = res2.getString("b_author");
                bookRecords[4] = res2.getInt("b_edition");
                bookRecords[5] = res2.getInt("b_for_year");
                bookRecords[6] = res2.getInt("b_count");
                dtm2.addRow(bookRecords);
                sno2++;

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    void loadFacIssuedData() {

        Connection con;
        Statement stmt;
        String qry;
        String name = this.getIssuName.getText();
        int sno = 1;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_Book_Record_System", "root", "");
            stmt = con.createStatement();
            qry = "Select * from db_Fac_Book_Issued where issu_fac_name = '" + name + "'";
            ResultSet res;
            res = stmt.executeQuery(qry);

            Object[] records = new Object[8];

            DefaultTableModel dtm;
            dtm = (DefaultTableModel) facBookIssedTable.getModel();
            dtm.setRowCount(0);

            while (res.next()) {

                records[0] = sno;
                records[1] = res.getInt("issu_fac_id");
                records[2] = res.getString("issu_book");
                records[3] = res.getString("issu_book_author");
                records[4] = res.getString("issu_book_code");
                records[5] = res.getString("issu_date");
                records[6] = res.getString("issu_reissue_date");
                records[7] = res.getString("issu_return_date");
                sno++;

                dtm.addRow(records);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        addPopUpMenu = new javax.swing.JPopupMenu();
        addStu = new javax.swing.JMenuItem();
        addFac = new javax.swing.JMenuItem();
        addIns = new javax.swing.JMenuItem();
        toolsPopUpMenu = new javax.swing.JPopupMenu();
        cngPass = new javax.swing.JMenuItem();
        cngInsDetails = new javax.swing.JMenuItem();
        bookPopUpMenu = new javax.swing.JPopupMenu();
        manageBook = new javax.swing.JMenuItem();
        issuedBook = new javax.swing.JMenuItem();
        headerPanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        close = new javax.swing.JPanel();
        closeIcon = new javax.swing.JLabel();
        minimize = new javax.swing.JPanel();
        minBtn = new javax.swing.JLabel();
        maximize = new javax.swing.JPanel();
        max = new javax.swing.JLabel();
        movePanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        Container = new javax.swing.JPanel();
        formPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        AddBookBtn = new javax.swing.JButton();
        returnTabBtn = new javax.swing.JButton();
        reissueBtn = new javax.swing.JButton();
        tabpane = new javax.swing.JTabbedPane();
        addBookTab = new javax.swing.JPanel();
        JTextField16 = new javax.swing.JLabel();
        issuBook = new javax.swing.JTextField();
        JTextField17 = new javax.swing.JLabel();
        issuBookAuthor = new javax.swing.JTextField();
        JTextField18 = new javax.swing.JLabel();
        addBtn = new javax.swing.JButton();
        JTextField19 = new javax.swing.JLabel();
        issuBookCode = new javax.swing.JTextField();
        getIssuName = new javax.swing.JTextField();
        updateBtn = new javax.swing.JButton();
        facIssuId = new javax.swing.JTextField();
        issuDate = new com.toedter.calendar.JDateChooser();
        JTextField22 = new javax.swing.JLabel();
        txt_search = new javax.swing.JTextField();
        bookId = new javax.swing.JTextField();
        bookAvaildfa = new javax.swing.JLabel();
        bookCount = new javax.swing.JLabel();
        returnTab = new javax.swing.JPanel();
        JTextField20 = new javax.swing.JLabel();
        returnBtn = new javax.swing.JButton();
        returnDate = new com.toedter.calendar.JDateChooser();
        reissueTab = new javax.swing.JPanel();
        JTextField21 = new javax.swing.JLabel();
        reissue = new javax.swing.JButton();
        reissueDate = new com.toedter.calendar.JDateChooser();
        dataPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        facBookIssedTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        bookRecordsTable = new javax.swing.JTable();
        menuPanel = new javax.swing.JPanel();
        AllIcons = new javax.swing.JPanel();
        homeIconPane = new javax.swing.JPanel();
        homeIcon = new javax.swing.JLabel();
        bookManagePane = new javax.swing.JPanel();
        bookIcon = new javax.swing.JLabel();
        addPane = new javax.swing.JPanel();
        addIcon = new javax.swing.JLabel();
        resetPassPane = new javax.swing.JPanel();
        resetPass = new javax.swing.JLabel();

        jToggleButton1.setText("jToggleButton1");

        addPopUpMenu.setBackground(new java.awt.Color(254, 254, 254));
        addPopUpMenu.setForeground(new java.awt.Color(1, 1, 1));

        addStu.setBackground(new java.awt.Color(254, 254, 254));
        addStu.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        addStu.setForeground(new java.awt.Color(1, 1, 1));
        addStu.setText("add Students");
        addStu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addStuMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addStuMousePressed(evt);
            }
        });
        addStu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStuActionPerformed(evt);
            }
        });
        addPopUpMenu.add(addStu);

        addFac.setBackground(new java.awt.Color(254, 238, 238));
        addFac.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        addFac.setForeground(new java.awt.Color(1, 1, 1));
        addFac.setText("add Faculty");
        addFac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addFacMousePressed(evt);
            }
        });
        addPopUpMenu.add(addFac);

        addIns.setBackground(new java.awt.Color(254, 254, 254));
        addIns.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        addIns.setForeground(new java.awt.Color(1, 1, 1));
        addIns.setText("add Instructor");
        addIns.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addInsMousePressed(evt);
            }
        });
        addPopUpMenu.add(addIns);

        toolsPopUpMenu.setBackground(new java.awt.Color(254, 254, 254));
        toolsPopUpMenu.setForeground(new java.awt.Color(1, 1, 1));

        cngPass.setBackground(new java.awt.Color(254, 254, 254));
        cngPass.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        cngPass.setForeground(new java.awt.Color(1, 1, 1));
        cngPass.setText("Change Password");
        cngPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cngPassMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cngPassMousePressed(evt);
            }
        });
        cngPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cngPassActionPerformed(evt);
            }
        });
        toolsPopUpMenu.add(cngPass);

        cngInsDetails.setBackground(new java.awt.Color(254, 254, 254));
        cngInsDetails.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        cngInsDetails.setForeground(new java.awt.Color(1, 1, 1));
        cngInsDetails.setText("Change Instructor Details");
        cngInsDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cngInsDetailsMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cngInsDetailsMousePressed(evt);
            }
        });
        cngInsDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cngInsDetailsActionPerformed(evt);
            }
        });
        toolsPopUpMenu.add(cngInsDetails);

        bookPopUpMenu.setBackground(new java.awt.Color(254, 254, 254));
        bookPopUpMenu.setForeground(new java.awt.Color(1, 1, 1));

        manageBook.setBackground(new java.awt.Color(254, 254, 254));
        manageBook.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        manageBook.setForeground(new java.awt.Color(1, 1, 1));
        manageBook.setText("Manage Books");
        manageBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                manageBookMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                manageBookMousePressed(evt);
            }
        });
        manageBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageBookActionPerformed(evt);
            }
        });
        bookPopUpMenu.add(manageBook);

        issuedBook.setBackground(new java.awt.Color(254, 238, 238));
        issuedBook.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        issuedBook.setForeground(new java.awt.Color(1, 1, 1));
        issuedBook.setText("See Issued Books");
        issuedBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                issuedBookMousePressed(evt);
            }
        });
        bookPopUpMenu.add(issuedBook);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        headerPanel.setBackground(new java.awt.Color(45, 45, 45));
        headerPanel.setForeground(new java.awt.Color(1, 1, 1));
        headerPanel.setOpaque(false);
        headerPanel.setPreferredSize(new java.awt.Dimension(50, 20));
        headerPanel.setLayout(new java.awt.BorderLayout());

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        close.setBackground(new java.awt.Color(45, 45, 45));
        close.setPreferredSize(new java.awt.Dimension(50, 50));

        closeIcon.setBackground(new java.awt.Color(97, 89, 224));
        closeIcon.setForeground(new java.awt.Color(97, 89, 224));
        closeIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        closeIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/cancel18.png"))); // NOI18N
        closeIcon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        closeIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeIconMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeIconMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeIconMouseExited(evt);
            }
        });

        javax.swing.GroupLayout closeLayout = new javax.swing.GroupLayout(close);
        close.setLayout(closeLayout);
        closeLayout.setHorizontalGroup(
            closeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(closeIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );
        closeLayout.setVerticalGroup(
            closeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, closeLayout.createSequentialGroup()
                .addComponent(closeIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel4.add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 30, 20));

        minimize.setBackground(new java.awt.Color(45, 45, 45));
        minimize.setPreferredSize(new java.awt.Dimension(50, 50));

        minBtn.setBackground(new java.awt.Color(45, 45, 45));
        minBtn.setForeground(new java.awt.Color(97, 89, 224));
        minBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/minus18.png"))); // NOI18N
        minBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minBtnMouseExited(evt);
            }
        });

        javax.swing.GroupLayout minimizeLayout = new javax.swing.GroupLayout(minimize);
        minimize.setLayout(minimizeLayout);
        minimizeLayout.setHorizontalGroup(
            minimizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(minimizeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(minBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
        );
        minimizeLayout.setVerticalGroup(
            minimizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(minimizeLayout.createSequentialGroup()
                .addComponent(minBtn)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanel4.add(minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 20));

        maximize.setBackground(new java.awt.Color(45, 45, 45));
        maximize.setPreferredSize(new java.awt.Dimension(50, 50));

        max.setBackground(new java.awt.Color(45, 45, 45));
        max.setForeground(new java.awt.Color(97, 89, 224));
        max.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        max.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/maxi18.png"))); // NOI18N
        max.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                maxMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                maxMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                maxMouseExited(evt);
            }
        });

        javax.swing.GroupLayout maximizeLayout = new javax.swing.GroupLayout(maximize);
        maximize.setLayout(maximizeLayout);
        maximizeLayout.setHorizontalGroup(
            maximizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(max, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );
        maximizeLayout.setVerticalGroup(
            maximizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(max, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel4.add(maximize, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 30, 20));

        headerPanel.add(jPanel4, java.awt.BorderLayout.LINE_END);

        movePanel.setBackground(new java.awt.Color(45, 45, 45));
        movePanel.setForeground(new java.awt.Color(255, 0, 0));
        movePanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                movePanelMouseDragged(evt);
            }
        });
        movePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                movePanelMousePressed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(254, 254, 254));
        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(254, 254, 254));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Book Record System");

        javax.swing.GroupLayout movePanelLayout = new javax.swing.GroupLayout(movePanel);
        movePanel.setLayout(movePanelLayout);
        movePanelLayout.setHorizontalGroup(
            movePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1275, Short.MAX_VALUE)
        );
        movePanelLayout.setVerticalGroup(
            movePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, movePanelLayout.createSequentialGroup()
                .addGap(0, 2, Short.MAX_VALUE)
                .addComponent(jLabel5))
        );

        headerPanel.add(movePanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(headerPanel, java.awt.BorderLayout.PAGE_START);

        Container.setLayout(new java.awt.BorderLayout());

        formPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        formPanel.setForeground(new java.awt.Color(254, 254, 254));
        formPanel.setMinimumSize(new java.awt.Dimension(500, 100));
        formPanel.setPreferredSize(new java.awt.Dimension(500, 724));

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(27, 27, 27));
        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(1, 1, 1));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Book Issue");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 12, 440, 31));

        lblName.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lblName.setForeground(new java.awt.Color(1, 1, 1));
        lblName.setText("Name");

        lblGender.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lblGender.setForeground(new java.awt.Color(1, 1, 1));
        lblGender.setText("Gender");

        AddBookBtn.setBackground(new java.awt.Color(254, 254, 254));
        AddBookBtn.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        AddBookBtn.setForeground(new java.awt.Color(1, 1, 1));
        AddBookBtn.setText("Add Books Tab");
        AddBookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBookBtnActionPerformed(evt);
            }
        });

        returnTabBtn.setBackground(new java.awt.Color(254, 254, 254));
        returnTabBtn.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        returnTabBtn.setForeground(new java.awt.Color(1, 1, 1));
        returnTabBtn.setText("Return Tab");
        returnTabBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                returnTabBtnMouseClicked(evt);
            }
        });
        returnTabBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnTabBtnActionPerformed(evt);
            }
        });

        reissueBtn.setBackground(new java.awt.Color(254, 254, 254));
        reissueBtn.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        reissueBtn.setForeground(new java.awt.Color(1, 1, 1));
        reissueBtn.setText("Reissue Tab");
        reissueBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reissueBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(AddBookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(returnTabBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(reissueBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblGender, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(lblGender, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddBookBtn)
                    .addComponent(returnTabBtn)
                    .addComponent(reissueBtn))
                .addGap(36, 36, 36))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 61, 440, 200));

        tabpane.setPreferredSize(new java.awt.Dimension(450, 540));
        tabpane.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                tabpaneComponentHidden(evt);
            }
        });

        JTextField16.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        JTextField16.setForeground(new java.awt.Color(1, 1, 1));
        JTextField16.setText("Book Name");

        issuBook.setBackground(new java.awt.Color(254, 254, 254));
        issuBook.setForeground(new java.awt.Color(1, 1, 1));

        JTextField17.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        JTextField17.setForeground(new java.awt.Color(1, 1, 1));
        JTextField17.setText("Author");

        issuBookAuthor.setBackground(new java.awt.Color(254, 254, 254));
        issuBookAuthor.setForeground(new java.awt.Color(1, 1, 1));

        JTextField18.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        JTextField18.setForeground(new java.awt.Color(1, 1, 1));
        JTextField18.setText("Issue Date");

        addBtn.setBackground(new java.awt.Color(254, 254, 254));
        addBtn.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        addBtn.setForeground(new java.awt.Color(1, 1, 1));
        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        JTextField19.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        JTextField19.setForeground(new java.awt.Color(1, 1, 1));
        JTextField19.setText("Book Code");

        issuBookCode.setBackground(new java.awt.Color(254, 254, 254));
        issuBookCode.setForeground(new java.awt.Color(1, 1, 1));

        getIssuName.setBackground(new java.awt.Color(254, 254, 254));
        getIssuName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getIssuNameActionPerformed(evt);
            }
        });

        updateBtn.setBackground(new java.awt.Color(254, 254, 254));
        updateBtn.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        updateBtn.setForeground(new java.awt.Color(1, 1, 1));
        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        facIssuId.setBackground(new java.awt.Color(254, 254, 254));
        facIssuId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facIssuIdActionPerformed(evt);
            }
        });

        JTextField22.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        JTextField22.setForeground(new java.awt.Color(1, 1, 1));
        JTextField22.setText("Search Books");

        txt_search.setBackground(new java.awt.Color(254, 254, 254));
        txt_search.setForeground(new java.awt.Color(1, 1, 1));
        txt_search.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_searchCaretUpdate(evt);
            }
        });
        txt_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_searchActionPerformed(evt);
            }
        });

        bookAvaildfa.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        bookAvaildfa.setForeground(new java.awt.Color(1, 1, 1));
        bookAvaildfa.setText("Book Availabilty : ");

        bookCount.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        bookCount.setForeground(new java.awt.Color(1, 1, 1));

        javax.swing.GroupLayout addBookTabLayout = new javax.swing.GroupLayout(addBookTab);
        addBookTab.setLayout(addBookTabLayout);
        addBookTabLayout.setHorizontalGroup(
            addBookTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addBookTabLayout.createSequentialGroup()
                .addGroup(addBookTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addBookTabLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(addBookTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(addBookTabLayout.createSequentialGroup()
                                .addComponent(JTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(issuBook, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(addBookTabLayout.createSequentialGroup()
                                .addComponent(JTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(issuBookAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(addBookTabLayout.createSequentialGroup()
                                .addComponent(JTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(issuBookCode, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(addBookTabLayout.createSequentialGroup()
                                .addGroup(addBookTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bookAvaildfa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(addBookTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bookCount, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(issuDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(addBookTabLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(addBookTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(facIssuId, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(getIssuName, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(143, 143, 143)
                        .addComponent(bookId, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addBookTabLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(JTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addBookTabLayout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        addBookTabLayout.setVerticalGroup(
            addBookTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addBookTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addBookTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addBookTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(issuBook, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addBookTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(issuBookAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addBookTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(issuBookCode, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(addBookTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addBookTabLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(JTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addBookTabLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(issuDate, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(addBookTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bookAvaildfa, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bookCount, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addBookTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn)
                    .addComponent(updateBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(addBookTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(getIssuName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bookId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(facIssuId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabpane.addTab("tab1", addBookTab);

        JTextField20.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        JTextField20.setForeground(new java.awt.Color(1, 1, 1));
        JTextField20.setText("Return Date");

        returnBtn.setBackground(new java.awt.Color(254, 254, 254));
        returnBtn.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        returnBtn.setForeground(new java.awt.Color(1, 1, 1));
        returnBtn.setText("Return");
        returnBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout returnTabLayout = new javax.swing.GroupLayout(returnTab);
        returnTab.setLayout(returnTabLayout);
        returnTabLayout.setHorizontalGroup(
            returnTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(returnTabLayout.createSequentialGroup()
                .addGroup(returnTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(returnTabLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(JTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(returnDate, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(returnTabLayout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(returnBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        returnTabLayout.setVerticalGroup(
            returnTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(returnTabLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(returnTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JTextField20, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(returnDate, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(returnBtn)
                .addContainerGap(341, Short.MAX_VALUE))
        );

        tabpane.addTab("tab2", returnTab);

        JTextField21.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        JTextField21.setForeground(new java.awt.Color(1, 1, 1));
        JTextField21.setText("Reissue Date");

        reissue.setBackground(new java.awt.Color(254, 254, 254));
        reissue.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        reissue.setForeground(new java.awt.Color(1, 1, 1));
        reissue.setText("Reissue");
        reissue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reissueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout reissueTabLayout = new javax.swing.GroupLayout(reissueTab);
        reissueTab.setLayout(reissueTabLayout);
        reissueTabLayout.setHorizontalGroup(
            reissueTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reissueTabLayout.createSequentialGroup()
                .addGroup(reissueTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(reissueTabLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(JTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(reissueDate, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(reissueTabLayout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(reissue, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        reissueTabLayout.setVerticalGroup(
            reissueTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reissueTabLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(reissueTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JTextField21, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(reissueDate, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(reissue)
                .addContainerGap(341, Short.MAX_VALUE))
        );

        tabpane.addTab("tab3", reissueTab);

        jPanel1.add(tabpane, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 420, 470));

        javax.swing.GroupLayout formPanelLayout = new javax.swing.GroupLayout(formPanel);
        formPanel.setLayout(formPanelLayout);
        formPanelLayout.setHorizontalGroup(
            formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 498, Short.MAX_VALUE)
            .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(formPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        formPanelLayout.setVerticalGroup(
            formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 722, Short.MAX_VALUE)
            .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(formPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
                    .addGap(19, 19, 19)))
        );

        Container.add(formPanel, java.awt.BorderLayout.LINE_START);

        dataPanel.setPreferredSize(new java.awt.Dimension(700, 700));

        jPanel2.setBackground(new java.awt.Color(254, 254, 254));

        facBookIssedTable.setBackground(new java.awt.Color(254, 254, 254));
        facBookIssedTable.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        facBookIssedTable.setForeground(new java.awt.Color(1, 1, 1));
        facBookIssedTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S.No", "Id", "Book Name", "Author", "Book Code", "Issue Date", "Reissue Date", "Return"
            }
        ));
        facBookIssedTable.setRowHeight(25);
        facBookIssedTable.setRowMargin(10);
        facBookIssedTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                facBookIssedTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(facBookIssedTable);

        jLabel4.setBackground(new java.awt.Color(27, 27, 27));
        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(1, 1, 1));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Book Details");

        bookRecordsTable.setBackground(new java.awt.Color(254, 254, 254));
        bookRecordsTable.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        bookRecordsTable.setForeground(new java.awt.Color(1, 1, 1));
        bookRecordsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S.No", "Id", "Book Name", "Author", "Edition", "For Year", "Count"
            }
        ));
        bookRecordsTable.setRowHeight(25);
        bookRecordsTable.setRowMargin(10);
        bookRecordsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookRecordsTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(bookRecordsTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 753, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout dataPanelLayout = new javax.swing.GroupLayout(dataPanel);
        dataPanel.setLayout(dataPanelLayout);
        dataPanelLayout.setHorizontalGroup(
            dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 825, Short.MAX_VALUE)
            .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(dataPanelLayout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(19, 19, 19)))
        );
        dataPanelLayout.setVerticalGroup(
            dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 724, Short.MAX_VALUE)
            .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(dataPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(20, 20, 20)))
        );

        Container.add(dataPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(Container, java.awt.BorderLayout.CENTER);

        menuPanel.setBackground(new java.awt.Color(60, 60, 60));
        menuPanel.setPreferredSize(new java.awt.Dimension(50, 670));
        menuPanel.setLayout(new java.awt.BorderLayout());

        AllIcons.setBackground(new java.awt.Color(53, 54, 53));
        AllIcons.setPreferredSize(new java.awt.Dimension(50, 1138));

        homeIconPane.setBackground(new java.awt.Color(53, 52, 53));
        homeIconPane.setPreferredSize(new java.awt.Dimension(36, 36));

        homeIcon.setBackground(new java.awt.Color(255, 0, 0));
        homeIcon.setForeground(new java.awt.Color(255, 0, 0));
        homeIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        homeIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/HomeIcon.png"))); // NOI18N
        homeIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeIconMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                homeIconMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                homeIconMouseExited(evt);
            }
        });

        javax.swing.GroupLayout homeIconPaneLayout = new javax.swing.GroupLayout(homeIconPane);
        homeIconPane.setLayout(homeIconPaneLayout);
        homeIconPaneLayout.setHorizontalGroup(
            homeIconPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeIconPaneLayout.createSequentialGroup()
                .addComponent(homeIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        homeIconPaneLayout.setVerticalGroup(
            homeIconPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(homeIcon, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        bookManagePane.setBackground(new java.awt.Color(53, 52, 53));
        bookManagePane.setPreferredSize(new java.awt.Dimension(36, 36));

        bookIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bookIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/books.png"))); // NOI18N
        bookIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookIconMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bookIconMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bookIconMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                bookIconMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout bookManagePaneLayout = new javax.swing.GroupLayout(bookManagePane);
        bookManagePane.setLayout(bookManagePaneLayout);
        bookManagePaneLayout.setHorizontalGroup(
            bookManagePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bookManagePaneLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(bookIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        bookManagePaneLayout.setVerticalGroup(
            bookManagePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bookIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        addPane.setBackground(new java.awt.Color(53, 52, 53));
        addPane.setPreferredSize(new java.awt.Dimension(35, 35));

        addIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/add.png"))); // NOI18N
        addIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addIconMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addIconMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addIconMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                addIconMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout addPaneLayout = new javax.swing.GroupLayout(addPane);
        addPane.setLayout(addPaneLayout);
        addPaneLayout.setHorizontalGroup(
            addPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        addPaneLayout.setVerticalGroup(
            addPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        resetPassPane.setBackground(new java.awt.Color(53, 52, 53));
        resetPassPane.setPreferredSize(new java.awt.Dimension(36, 36));

        resetPass.setBackground(new java.awt.Color(255, 0, 0));
        resetPass.setForeground(new java.awt.Color(255, 0, 0));
        resetPass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        resetPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/setting.png"))); // NOI18N
        resetPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetPassMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                resetPassMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                resetPassMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                resetPassMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout resetPassPaneLayout = new javax.swing.GroupLayout(resetPassPane);
        resetPassPane.setLayout(resetPassPaneLayout);
        resetPassPaneLayout.setHorizontalGroup(
            resetPassPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resetPassPaneLayout.createSequentialGroup()
                .addComponent(resetPass, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        resetPassPaneLayout.setVerticalGroup(
            resetPassPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(resetPass, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout AllIconsLayout = new javax.swing.GroupLayout(AllIcons);
        AllIcons.setLayout(AllIconsLayout);
        AllIconsLayout.setHorizontalGroup(
            AllIconsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AllIconsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AllIconsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(homeIconPane, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(AllIconsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(addPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                        .addComponent(bookManagePane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                    .addComponent(resetPassPane, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        AllIconsLayout.setVerticalGroup(
            AllIconsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AllIconsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(homeIconPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bookManagePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(resetPassPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(515, Short.MAX_VALUE))
        );

        menuPanel.add(AllIcons, java.awt.BorderLayout.LINE_START);

        getContentPane().add(menuPanel, java.awt.BorderLayout.LINE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeIconMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_closeIconMouseClicked

    private void closeIconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeIconMouseEntered
        // TODO add your handling code here:
        changeColor(close, hoverColor);
    }//GEN-LAST:event_closeIconMouseEntered

    private void closeIconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeIconMouseExited
        // TODO add your handling code here:
        changeColor(close, headerColor);
    }//GEN-LAST:event_closeIconMouseExited

    private void minBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minBtnMouseClicked
        // TODO add your handling code here:
        setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_minBtnMouseClicked

    private void minBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minBtnMouseEntered
        // TODO add your handling code here:
        changeColor(minimize, hoverColor);
    }//GEN-LAST:event_minBtnMouseEntered

    private void minBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minBtnMouseExited
        // TODO add your handling code here:
        changeColor(minimize, headerColor);
    }//GEN-LAST:event_minBtnMouseExited

    private void maxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maxMouseClicked
        // TODO add your handling code here:

        if (this.getExtendedState() != JFrame.MAXIMIZED_BOTH) {
            this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        } else {
            this.setExtendedState(JFrame.NORMAL);

        }
    }//GEN-LAST:event_maxMouseClicked

    private void maxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maxMouseEntered
        // TODO add your handling code here:
        changeColor(maximize, hoverColor);
    }//GEN-LAST:event_maxMouseEntered

    private void maxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maxMouseExited
        // TODO add your handling code here:
        changeColor(maximize, headerColor);
    }//GEN-LAST:event_maxMouseExited

    private void movePanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_movePanelMouseDragged
        // TODO add your handling code here:
        int thisX = evt.getXOnScreen();
        int thisY = evt.getYOnScreen();
        this.setLocation(thisX - mousepX, thisY - mousepY);
    }//GEN-LAST:event_movePanelMouseDragged

    private void movePanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_movePanelMousePressed
        // TODO add your handling code here:
        // get location of Window
        mousepX = evt.getX();
        mousepY = evt.getY();
    }//GEN-LAST:event_movePanelMousePressed

    private void homeIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeIconMouseClicked
        // TODO add your handling code here:
        MainScreen ms = new MainScreen();
        ms.setVisible(true);
        dispose();
    }//GEN-LAST:event_homeIconMouseClicked

    private void homeIconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeIconMouseEntered
        // TODO add your handling code here:
        changeColor(homeIconPane, darkBalck);
    }//GEN-LAST:event_homeIconMouseEntered

    private void homeIconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeIconMouseExited
        // TODO add your handling code here:
        changeColor(homeIconPane, menuPanelColor);
    }//GEN-LAST:event_homeIconMouseExited

    private void bookIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookIconMouseClicked
        // TODO add your handling code here:
        ManageBooks mb = new ManageBooks();
        mb.setVisible(true);
        dispose();
    }//GEN-LAST:event_bookIconMouseClicked

    private void bookIconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookIconMouseEntered
        // TODO add your handling code here:
        changeColor(bookManagePane, darkBalck);
    }//GEN-LAST:event_bookIconMouseEntered

    private void bookIconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookIconMouseExited
        // TODO add your handling code here:
        changeColor(bookManagePane, menuPanelColor);
    }//GEN-LAST:event_bookIconMouseExited

    private void addIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addIconMouseClicked
        // TODO add your handling code here:
        if (evt.isPopupTrigger()) {
            addPopUpMenu.show(this, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_addIconMouseClicked

    private void addIconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addIconMouseEntered
        // TODO add your handling code here:
        changeColor(addPane, darkBalck);
    }//GEN-LAST:event_addIconMouseEntered

    private void addIconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addIconMouseExited
        // TODO add your handling code here:
        changeColor(addPane, menuPanelColor);
    }//GEN-LAST:event_addIconMouseExited

    private void addIconMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addIconMouseReleased
        // TODO add your handling code here:
        if (evt.getButton() == 1) { // 1-left, 2-middle, 3-right button
            addPopUpMenu.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_addIconMouseReleased

    private void resetPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetPassMouseClicked
        // TODO add your handling code here:
        ChangePassword cp = new ChangePassword();
        cp.setVisible(true);
        cp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }//GEN-LAST:event_resetPassMouseClicked

    private void resetPassMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetPassMouseEntered
        // TODO add your handling code here:
        changeColor(resetPassPane, darkBalck);
    }//GEN-LAST:event_resetPassMouseEntered

    private void resetPassMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetPassMouseExited
        // TODO add your handling code here:
        changeColor(resetPassPane, menuPanelColor);
    }//GEN-LAST:event_resetPassMouseExited

    private void resetPassMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetPassMouseReleased
        if (evt.getButton() == 1) { // 1-left, 2-middle, 3-right button
            toolsPopUpMenu.show(evt.getComponent(), evt.getX(), evt.getY());
        }        // TODO add your handling code here:

    }//GEN-LAST:event_resetPassMouseReleased

    private void AddBookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBookBtnActionPerformed
        // TODO add your handling code here:
        tabpane.setVisible(true);
        tabpane.setSelectedIndex(0);

    }//GEN-LAST:event_AddBookBtnActionPerformed

    private void returnTabBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnTabBtnMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_returnTabBtnMouseClicked

    private void returnTabBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnTabBtnActionPerformed
        // TODO add your handling code here:
        tabpane.setVisible(true);
        tabpane.setSelectedIndex(1);
        //        LocalDate getDate = LocalDate.now();
        //        String returnDate = new SimpleDateFormat("dd-MM-yyyy").format(getDate);
        //        System.out.println("Return Date : "+returnDate);

    }//GEN-LAST:event_returnTabBtnActionPerformed

    private void reissueBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reissueBtnActionPerformed
        // TODO add your handling code here:
        tabpane.setVisible(true);
        tabpane.setSelectedIndex(2);

    }//GEN-LAST:event_reissueBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:

        String issuName, issuBook, issuBookAuthor, issueDate, reissueDate = "", returnDate = "";
        int issuBookCode;
        //        issuName = ms.name;
        issuBook = this.issuBook.getText();
        issuBookAuthor = this.issuBookAuthor.getText();
        issuBookCode = Integer.parseInt(this.issuBookCode.getText());
        issuName = getIssuName.getText();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        issueDate = dateFormat.format(issuDate.getDate());

        Connection con;
        Statement stmt;
        String qry;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_Book_Record_System", "root", "");

            qry = "INSERT INTO db_Fac_Book_Issued(issu_fac_name,issu_book,issu_book_author,issu_book_code,issu_date,issu_reissue_date,issu_return_date) VALUES('" + issuName + "' ,'" + issuBook + "','" + issuBookAuthor + "'," + issuBookCode + " , '" + issueDate + "', '" + reissueDate + "', '" + returnDate + "') ";
            stmt = con.createStatement();
            int row = stmt.executeUpdate(qry);
            if (row > 0 && bookAvailable > 0) {
                JOptionPane.showMessageDialog(this, "Data Added");
                bookAvailable -= 1;
                try {
                    Statement stmt2 = con.createStatement();
                    String qry2 = "UPDATE db_Book SET  b_count=" + bookAvailable + " WHERE b_id='" + bookId.getText() + "'";
                    int row2 = stmt.executeUpdate(qry2);
                    if (row2 > 0) {
//                JOptionPane.showMessageDialog(this, "count Update Succssesfully");
                        loadBookData();

                    } else {
                        JOptionPane.showMessageDialog(this, "Sorry count not Updated.");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e);
                }
                loadFacIssuedData();

            } else {
                JOptionPane.showMessageDialog(this, "Sorry Book Not Available");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }

    }//GEN-LAST:event_addBtnActionPerformed

    private void getIssuNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getIssuNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_getIssuNameActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:
        String issuBook, issuBookAuthor, issueDate;
        int issuBookCode;
        issuBook = this.issuBook.getText();
        issuBookAuthor = this.issuBookAuthor.getText();
        issuBookCode = Integer.parseInt(this.issuBookCode.getText());

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        issueDate = dateFormat.format(issuDate.getDate());
        Connection con;
        Statement stmt;
        String qry;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_Book_Record_System", "root", "");
            stmt = con.createStatement();
            qry = "UPDATE db_Fac_Book_Issued SET issu_book = '" + issuBook + "', issu_book_author='" + issuBookAuthor + "',issu_book_code=" + issuBookCode + " ,issu_date='" + issueDate + "' WHERE issu_id = " + facIssuId.getText();

            int row = stmt.executeUpdate(qry);
            if (row > 0) {
                JOptionPane.showMessageDialog(this, "Update Succssesfully");

                loadFacIssuedData();
            } else {
                JOptionPane.showMessageDialog(this, "Sorry not Updated.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void facIssuIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facIssuIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_facIssuIdActionPerformed

    private void returnBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnBtnActionPerformed
        // TODO add your handling code here:
        String issuBook, issuBookAuthor, returnDate;
        int issuBookCode;
        issuBook = this.issuBook.getText();
        issuBookAuthor = this.issuBookAuthor.getText();
        issuBookCode = Integer.parseInt(this.issuBookCode.getText());

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        returnDate = dateFormat.format(issuDate.getDate());
        Connection con;
        Statement stmt;
        String qry;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_Book_Record_System", "root", "");
            stmt = con.createStatement();
            qry = "UPDATE db_Fac_Book_Issued SET issu_return_date='" + returnDate + "' WHERE issu_fac_id = " + facIssuId.getText();

            int row = stmt.executeUpdate(qry);
            if (row > 0) {
                JOptionPane.showMessageDialog(this, "Return Succssesfully");
                bookAvailable += 1;
                try {
                    Statement stmt2 = con.createStatement();
                    String qry2 = "UPDATE db_Book SET  b_count=" + bookAvailable + " WHERE b_name='" + this.issuBook.getText() + "' and b_author='" + this.issuBookAuthor.getText() + "'";
                    int row2 = stmt.executeUpdate(qry2);
                    if (row2 > 0) {
//                JOptionPane.showMessageDialog(this, "count Update Succssesfully");
                        loadBookData();

                    } else {
                        JOptionPane.showMessageDialog(this, "Sorry count not Updated.");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e);
                }
                loadFacIssuedData();
            } else {
                JOptionPane.showMessageDialog(this, "Sorry not Updated.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_returnBtnActionPerformed

    private void reissueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reissueActionPerformed
        // TODO add your handling code here:
        String reissueDate;

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        reissueDate = dateFormat.format(this.reissueDate.getDate());
        Connection con;
        Statement stmt;
        String qry;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_Book_Record_System", "root", "");
            stmt = con.createStatement();
            qry = "UPDATE db_Fac_Book_Issued SET issu_reissue_date='" + reissueDate + "' WHERE issu_fac_id = " + facIssuId.getText();

            int row = stmt.executeUpdate(qry);
            if (row > 0) {
                JOptionPane.showMessageDialog(this, "Reissue Succssesfully");
                loadFacIssuedData();
            } else {
                JOptionPane.showMessageDialog(this, "Sorry not Updated.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_reissueActionPerformed

    private void tabpaneComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tabpaneComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_tabpaneComponentHidden

    private void facBookIssedTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_facBookIssedTableMouseClicked
        // TODO add your handling code here:
        int row = facBookIssedTable.getSelectedRow();
        TableModel tm = facBookIssedTable.getModel();
        //        Date issueDate=null,reissueDate=null,returnDate=null;
        Date issueDate, reissueDate, returnDate;

        String getIssueDate, getReissueDate, getReturnDate;

        facIssuId.setText(tm.getValueAt(row, 1).toString());
        issuBook.setText(tm.getValueAt(row, 2).toString());
        issuBookAuthor.setText(tm.getValueAt(row, 3).toString());
        issuBookCode.setText((String) tm.getValueAt(row, 4));
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());

        getIssueDate = tm.getValueAt(row, 5).toString();
        getReissueDate = tm.getValueAt(row, 6).toString();
        getReturnDate = tm.getValueAt(row, 7).toString();
//        bookAvailable();

        try {
            if (getReissueDate.equals("") || getReissueDate == null) {
                this.reissueDate.setDate(null);
            } else {
                reissueDate = new SimpleDateFormat("dd-MM-yyyy").parse(getReissueDate);
                this.reissueDate.setDate(reissueDate);
            }
            if (getReturnDate.equals("") || getReturnDate == null) {
                this.returnDate.setDate(null);
            } else {

                returnDate = new SimpleDateFormat("dd-MM-yyyy").parse(getReturnDate);
                this.returnDate.setDate(returnDate);
            }
            issueDate = new SimpleDateFormat("dd-MM-yyyy").parse(getIssueDate);
            //            this.issueDate.setDate(date);

            this.issuDate.setDate(issueDate);

            Connection con2;
            Statement stmt2;
            ResultSet res2;
//        PreparedStatement ps;
            String qry2;
//        DefaultTableModel dtm2;
//            int sno2 = 1;
            String bName = this.issuBook.getText();
            String bAuthName = this.issuBookAuthor.getText();

            try {
                con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_Book_Record_System", "root", "");
                stmt2 = con2.createStatement();
                qry2 = "SELECT b_count FROM db_Book WHERE b_name='" + bName + "' and b_author='" + bAuthName + "'";
//                ps = con2.prepareStatement(qry2);

                res2 = stmt2.executeQuery(qry2);
//                ps.setString(1, bName);
//                ps.setString(2, bAuthName);
//                res2 = ps.executeQuery();
                if (res2.next()) {
//            bookAvailable = Integer.parseInt(res2.getString("b_count"));
                    bookCount.setText(res2.getString("b_count"));
//                    bookAvailable = Integer.parseInt(bookAvail.getText());
                    bookAvailable();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e);
            }

        } catch (ParseException ex) {
            Logger.getLogger(IssueBook.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_facBookIssedTableMouseClicked

    private void addStuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addStuMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_addStuMouseClicked

    private void addStuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addStuMousePressed
        // TODO add your handling code here:

        AddStudent as = new AddStudent();
        as.setVisible(true);
        dispose();
    }//GEN-LAST:event_addStuMousePressed

    private void addStuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addStuActionPerformed

    private void addFacMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addFacMousePressed
        // TODO add your handling code here:
        AddFaculty af = new AddFaculty();
        af.setVisible(true);
        dispose();
    }//GEN-LAST:event_addFacMousePressed

    private void addInsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addInsMousePressed
        // TODO add your handling code here:
        AddInstructor ai = new AddInstructor();
        ai.setVisible(true);
        dispose();
    }//GEN-LAST:event_addInsMousePressed

    private void txt_searchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_searchCaretUpdate
        // TODO add your handling code here:
        Connection con;
        Statement stmt;
        ResultSet res;
        String qry;
        DefaultTableModel dtm;
        int sno = 1;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_Book_Record_System", "root", "");
            stmt = con.createStatement();
            qry = "Select * from db_Book where b_name like '%" + txt_search.getText() + "%'";
            res = stmt.executeQuery(qry);

            Object[] bookRecords = new Object[7];

            dtm = (DefaultTableModel) bookRecordsTable.getModel();
            dtm.setRowCount(0);

            while (res.next()) {
                bookRecords[0] = sno;
                bookRecords[1] = res.getInt("b_id");
                bookRecords[2] = res.getString("b_name");
                bookRecords[3] = res.getString("b_author");
                bookRecords[4] = res.getInt("b_edition");
                bookRecords[5] = res.getInt("b_for_year");
                bookRecords[6] = res.getInt("b_count");
                dtm.addRow(bookRecords);
                sno++;

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_txt_searchCaretUpdate

    private void txt_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_searchActionPerformed

    private void bookRecordsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookRecordsTableMouseClicked
        // TODO add your handling code here:
        int row = bookRecordsTable.getSelectedRow();
        TableModel tm = bookRecordsTable.getModel();
        bookId.setText(tm.getValueAt(row, 1).toString());
        bookCount.setText(tm.getValueAt(row, 6).toString());

        bookAvailable();
//        bookAvail.setText(tm.getValueAt(row, 6).toString());
//        bookAvailable = Integer.parseInt(bookAvail.getText());
        issuBook.setText(tm.getValueAt(row, 2).toString());
        issuBookAuthor.setText((String) tm.getValueAt(row, 3));
    }//GEN-LAST:event_bookRecordsTableMouseClicked

    private void cngPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cngPassMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cngPassMouseClicked

    private void cngPassMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cngPassMousePressed
        // TODO add your handling code here:
        ChangePassword cp = new ChangePassword();
        cp.setVisible(true);
        cp.setLocationRelativeTo(null);
        cp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_cngPassMousePressed

    private void cngPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cngPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cngPassActionPerformed

    private void cngInsDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cngInsDetailsMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_cngInsDetailsMouseClicked

    private void cngInsDetailsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cngInsDetailsMousePressed
        // TODO add your handling code here:
        ChangeInsDetails cid = new ChangeInsDetails();
        cid.setVisible(true);
        dispose();
    }//GEN-LAST:event_cngInsDetailsMousePressed

    private void cngInsDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cngInsDetailsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cngInsDetailsActionPerformed

    private void manageBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageBookMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_manageBookMouseClicked

    private void manageBookMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageBookMousePressed
        // TODO add your handling code here:
        ManageBooks mb = new ManageBooks();
        mb.setVisible(true);
        dispose();
    }//GEN-LAST:event_manageBookMousePressed

    private void manageBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageBookActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_manageBookActionPerformed

    private void issuedBookMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_issuedBookMousePressed
        new IssuedBooks().setVisible(true);
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_issuedBookMousePressed

    private void bookIconMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookIconMouseReleased
        if (evt.getButton() == 1) { // 1-left, 2-middle, 3-right button
            bookPopUpMenu.show(evt.getComponent(), evt.getX(), evt.getY());
        }        // TODO add your handling code here:
    }//GEN-LAST:event_bookIconMouseReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new facIssueBook().setVisible(true);
                addBookTab.setVisible(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBookBtn;
    private javax.swing.JPanel AllIcons;
    private javax.swing.JPanel Container;
    private javax.swing.JLabel JTextField16;
    private javax.swing.JLabel JTextField17;
    private javax.swing.JLabel JTextField18;
    private javax.swing.JLabel JTextField19;
    private javax.swing.JLabel JTextField20;
    private javax.swing.JLabel JTextField21;
    private javax.swing.JLabel JTextField22;
    public static javax.swing.JPanel addBookTab;
    private javax.swing.JButton addBtn;
    private javax.swing.JMenuItem addFac;
    private javax.swing.JLabel addIcon;
    private javax.swing.JMenuItem addIns;
    private javax.swing.JPanel addPane;
    private javax.swing.JPopupMenu addPopUpMenu;
    private javax.swing.JMenuItem addStu;
    private javax.swing.JLabel bookAvaildfa;
    private javax.swing.JLabel bookCount;
    private javax.swing.JLabel bookIcon;
    private javax.swing.JTextField bookId;
    private javax.swing.JPanel bookManagePane;
    private javax.swing.JPopupMenu bookPopUpMenu;
    private javax.swing.JTable bookRecordsTable;
    private javax.swing.JPanel close;
    private javax.swing.JLabel closeIcon;
    private javax.swing.JMenuItem cngInsDetails;
    private javax.swing.JMenuItem cngPass;
    private javax.swing.JPanel dataPanel;
    private javax.swing.JTable facBookIssedTable;
    public static javax.swing.JTextField facIssuId;
    private javax.swing.JPanel formPanel;
    public static javax.swing.JTextField getIssuName;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel homeIcon;
    private javax.swing.JPanel homeIconPane;
    private javax.swing.JTextField issuBook;
    private javax.swing.JTextField issuBookAuthor;
    private javax.swing.JTextField issuBookCode;
    private com.toedter.calendar.JDateChooser issuDate;
    private javax.swing.JMenuItem issuedBook;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToggleButton jToggleButton1;
    public javax.swing.JLabel lblGender;
    public javax.swing.JLabel lblName;
    private javax.swing.JMenuItem manageBook;
    private javax.swing.JLabel max;
    private javax.swing.JPanel maximize;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JLabel minBtn;
    private javax.swing.JPanel minimize;
    private javax.swing.JPanel movePanel;
    private javax.swing.JButton reissue;
    private javax.swing.JButton reissueBtn;
    private com.toedter.calendar.JDateChooser reissueDate;
    private javax.swing.JPanel reissueTab;
    private javax.swing.JLabel resetPass;
    private javax.swing.JPanel resetPassPane;
    private javax.swing.JButton returnBtn;
    private com.toedter.calendar.JDateChooser returnDate;
    private javax.swing.JPanel returnTab;
    private javax.swing.JButton returnTabBtn;
    private javax.swing.JTabbedPane tabpane;
    private javax.swing.JPopupMenu toolsPopUpMenu;
    public javax.swing.JTextField txt_search;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables

}
