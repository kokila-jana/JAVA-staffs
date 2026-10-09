package new_Pack;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.WindowConstants;

public class BusBookAdvanced implements ActionListener {

    // ---------------- FRAME ----------------

    JFrame frame;

    // ---------------- TEXT FIELDS ----------------

    JTextField nameField;
    JTextField contactField;
    JTextField priceField;
    JTextField bookingIdField;

    // ---------------- COMBO BOXES ----------------

    JComboBox<String> fromCombo;
    JComboBox<String> toCombo;
    JComboBox<String> seatCombo;
    JComboBox<String> busTypeCombo;
    JComboBox<String> timingCombo;
    JComboBox<String> paymentCombo;

    JComboBox<String> travelDayCombo;
    JComboBox<String> travelMonthCombo;
    JComboBox<String> travelYearCombo;

    JComboBox<String> dobDayCombo;
    JComboBox<String> dobMonthCombo;
    JComboBox<String> dobYearCombo;

    // ---------------- RADIO BUTTONS ----------------

    JRadioButton maleRadio;
    JRadioButton femaleRadio;
    ButtonGroup genderGroup;

    // ---------------- CHECK BOX ----------------

    JCheckBox termsCheckBox;

    // ---------------- TEXT AREA ----------------

    JTextArea ticketArea;

    // ---------------- BUTTONS ----------------

    JButton bookButton;
    JButton clearButton;
    JButton saveButton;
    JButton printButton;
    JButton searchButton;
    JButton cancelButton;

    // ---------------- BOOKING STORAGE ----------------

    Map<String, String> bookings = new HashMap<>();

    // ---------------- DATA ----------------

    String[] locations = {
        "Select",
        "Salem",
        "Namakkal",
        "Erode",
        "Karur",
        "Chennai"
    };

    String[] seats = {
        "1", "2", "3", "4", "5",
        "6", "7", "8", "9", "10",
        "11", "12", "13", "14", "15",
        "16", "17", "18", "19", "20"
    };

    String[] seatCount = {
        "1", "2", "3", "4", "5"
    };

    String[] busTypes = {
        "AC",
        "Non-AC",
        "Sleeper"
    };

    String[] timings = {
        "06:00 AM",
        "09:00 AM",
        "01:00 PM",
        "05:00 PM",
        "09:00 PM"
    };

    String[] paymentMethods = {
        "Cash",
        "UPI",
        "Debit Card",
        "Credit Card"
    };

    String[] dates = {
        "1", "2", "3", "4", "5",
        "6", "7", "8", "9", "10",
        "11", "12", "13", "14", "15",
        "16", "17", "18", "19", "20",
        "21", "22", "23", "24", "25",
        "26", "27", "28", "29", "30", "31"
    };

    String[] months = {
        "Jan", "Feb", "Mar", "Apr",
        "May", "Jun", "Jul", "Aug",
        "Sep", "Oct", "Nov", "Dec"
    };

    String[] years = {
        "2026", "2027", "2028",
        "2029", "2030"
    };

    String[] dobYears = {
        "1990", "1991", "1992", "1993",
        "1994", "1995", "1996", "1997",
        "1998", "1999", "2000", "2001",
        "2002", "2003", "2004", "2005",
        "2006", "2007", "2008", "2009",
        "2010", "2011", "2012", "2013",
        "2014", "2015", "2016", "2017",
        "2018", "2019"
    };

    // ---------------- CONSTRUCTOR ----------------

    public BusBookAdvanced() {
        createGUI();
    }

    // ---------------- CREATE GUI ----------------

    public void createGUI() {

        frame = new JFrame("JMSMK Travels - Advanced Bus Booking System");

        frame.setSize(1200, 850);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // ---------------- TITLE ----------------

        JLabel title = new JLabel("JMSMK TRAVELS - BUS BOOKING SYSTEM");
        title.setBounds(350, 20, 600, 40);
        title.setFont(new Font("Arial", Font.BOLD, 25));
        frame.add(title);

        // ---------------- BOOKING ID ----------------

        JLabel bookingIdLabel = new JLabel("Booking ID");
        bookingIdLabel.setBounds(50, 80, 150, 30);
        bookingIdLabel.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(bookingIdLabel);

        bookingIdField = new JTextField();
        bookingIdField.setBounds(200, 80, 250, 35);
        bookingIdField.setEditable(false);
        frame.add(bookingIdField);

        // ---------------- PASSENGER NAME ----------------

        JLabel nameLabel = new JLabel("Passenger Name");
        nameLabel.setBounds(50, 130, 150, 30);
        frame.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(200, 130, 250, 35);
        frame.add(nameField);

        // ---------------- CONTACT ----------------

        JLabel contactLabel = new JLabel("Contact Number");
        contactLabel.setBounds(50, 180, 150, 30);
        frame.add(contactLabel);

        contactField = new JTextField();
        contactField.setBounds(200, 180, 250, 35);
        frame.add(contactField);

        // ---------------- FROM ----------------

        JLabel fromLabel = new JLabel("From");
        fromLabel.setBounds(500, 80, 100, 30);
        frame.add(fromLabel);

        fromCombo = new JComboBox<>(locations);
        fromCombo.setBounds(600, 80, 180, 35);
        fromCombo.addActionListener(this);
        frame.add(fromCombo);

        // ---------------- TO ----------------

        JLabel toLabel = new JLabel("To");
        toLabel.setBounds(500, 130, 100, 30);
        frame.add(toLabel);

        toCombo = new JComboBox<>(locations);
        toCombo.setBounds(600, 130, 180, 35);
        toCombo.addActionListener(this);
        frame.add(toCombo);

        // ---------------- BUS TYPE ----------------

        JLabel busTypeLabel = new JLabel("Bus Type");
        busTypeLabel.setBounds(500, 180, 100, 30);
        frame.add(busTypeLabel);

        busTypeCombo = new JComboBox<>(busTypes);
        busTypeCombo.setBounds(600, 180, 180, 35);
        busTypeCombo.addActionListener(this);
        frame.add(busTypeCombo);

        // ---------------- BUS TIMING ----------------

        JLabel timingLabel = new JLabel("Bus Timing");
        timingLabel.setBounds(500, 230, 100, 30);
        frame.add(timingLabel);

        timingCombo = new JComboBox<>(timings);
        timingCombo.setBounds(600, 230, 180, 35);
        frame.add(timingCombo);

        // ---------------- SEAT COUNT ----------------

        JLabel seatCountLabel = new JLabel("No. of Seats");
        seatCountLabel.setBounds(50, 240, 150, 30);
        frame.add(seatCountLabel);

        seatCombo = new JComboBox<>(seatCount);
        seatCombo.setBounds(200, 240, 100, 35);
        seatCombo.addActionListener(this);
        frame.add(seatCombo);

        // ---------------- SEAT NUMBER ----------------

        JLabel seatNumberLabel = new JLabel("Starting Seat");
        seatNumberLabel.setBounds(50, 290, 150, 30);
        frame.add(seatNumberLabel);

        JComboBox<String> startingSeatCombo = new JComboBox<>(seats);
        startingSeatCombo.setBounds(200, 290, 100, 35);
        frame.add(startingSeatCombo);

        // ---------------- PRICE ----------------

        JLabel priceLabel = new JLabel("Total Fare");
        priceLabel.setBounds(500, 280, 100, 30);
        frame.add(priceLabel);

        priceField = new JTextField();
        priceField.setBounds(600, 280, 180, 35);
        priceField.setEditable(false);
        frame.add(priceField);

        // ---------------- DOB ----------------

        JLabel dobLabel = new JLabel("Date of Birth");
        dobLabel.setBounds(50, 350, 150, 30);
        frame.add(dobLabel);

        dobDayCombo = new JComboBox<>(dates);
        dobDayCombo.setBounds(200, 350, 60, 35);
        frame.add(dobDayCombo);

        dobMonthCombo = new JComboBox<>(months);
        dobMonthCombo.setBounds(270, 350, 70, 35);
        frame.add(dobMonthCombo);

        dobYearCombo = new JComboBox<>(dobYears);
        dobYearCombo.setBounds(350, 350, 80, 35);
        frame.add(dobYearCombo);

        // ---------------- GENDER ----------------

        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setBounds(500, 350, 100, 30);
        frame.add(genderLabel);

        maleRadio = new JRadioButton("Male");
        maleRadio.setBounds(600, 350, 80, 30);
        maleRadio.setSelected(true);
        frame.add(maleRadio);

        femaleRadio = new JRadioButton("Female");
        femaleRadio.setBounds(690, 350, 90, 30);
        frame.add(femaleRadio);

        genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);

        // ---------------- TRAVEL DATE ----------------

        JLabel travelDateLabel = new JLabel("Travel Date");
        travelDateLabel.setBounds(50, 400, 150, 30);
        frame.add(travelDateLabel);

        travelDayCombo = new JComboBox<>(dates);
        travelDayCombo.setBounds(200, 400, 60, 35);
        frame.add(travelDayCombo);

        travelMonthCombo = new JComboBox<>(months);
        travelMonthCombo.setBounds(270, 400, 70, 35);
        frame.add(travelMonthCombo);

        travelYearCombo = new JComboBox<>(years);
        travelYearCombo.setBounds(350, 400, 80, 35);
        frame.add(travelYearCombo);

        // ---------------- PAYMENT ----------------

        JLabel paymentLabel = new JLabel("Payment");
        paymentLabel.setBounds(500, 400, 100, 30);
        frame.add(paymentLabel);

        paymentCombo = new JComboBox<>(paymentMethods);
        paymentCombo.setBounds(600, 400, 180, 35);
        frame.add(paymentCombo);

        // ---------------- TERMS ----------------

        termsCheckBox = new JCheckBox(
            "I accept the Terms and Conditions"
        );

        termsCheckBox.setBounds(50, 460, 300, 35);
        frame.add(termsCheckBox);

        // ---------------- BUTTONS ----------------

        bookButton = new JButton("Book Ticket");
        bookButton.setBounds(50, 520, 130, 40);
        bookButton.addActionListener(this);
        frame.add(bookButton);

        clearButton = new JButton("Clear");
        clearButton.setBounds(190, 520, 100, 40);
        clearButton.addActionListener(this);
        frame.add(clearButton);

        saveButton = new JButton("Save Ticket");
        saveButton.setBounds(300, 520, 120, 40);
        saveButton.addActionListener(this);
        frame.add(saveButton);

        printButton = new JButton("Print Ticket");
        printButton.setBounds(430, 520, 120, 40);
        printButton.addActionListener(this);
        frame.add(printButton);

        searchButton = new JButton("Search");
        searchButton.setBounds(560, 520, 100, 40);
        searchButton.addActionListener(this);
        frame.add(searchButton);

        cancelButton = new JButton("Cancel Booking");
        cancelButton.setBounds(670, 520, 140, 40);
        cancelButton.addActionListener(this);
        frame.add(cancelButton);

        // ---------------- TICKET AREA ----------------

        JLabel ticketLabel = new JLabel("Generated Ticket");
        ticketLabel.setBounds(850, 80, 200, 30);
        ticketLabel.setFont(new Font("Arial", Font.BOLD, 18));
        frame.add(ticketLabel);

        ticketArea = new JTextArea();
        ticketArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        ticketArea.setEditable(false);
        ticketArea.setLineWrap(true);
        ticketArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(ticketArea);
        scrollPane.setBounds(850, 120, 300, 500);
        frame.add(scrollPane);

        // ---------------- SHOW FRAME ----------------

        frame.setVisible(true);
    }

    // ---------------- EVENT HANDLER ----------------

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == fromCombo ||
            e.getSource() == toCombo ||
            e.getSource() == busTypeCombo ||
            e.getSource() == seatCombo) {

            calculateFare();
        }

        if (e.getSource() == bookButton) {
            bookTicket();
        }

        if (e.getSource() == clearButton) {
            clearForm();
        }

        if (e.getSource() == saveButton) {
            saveTicket();
        }

        if (e.getSource() == printButton) {
            printTicket();
        }

        if (e.getSource() == searchButton) {
            searchBooking();
        }

        if (e.getSource() == cancelButton) {
            cancelBooking();
        }
    }

    // ---------------- FARE CALCULATION ----------------

    private void calculateFare() {

        String from = (String) fromCombo.getSelectedItem();
        String to = (String) toCombo.getSelectedItem();

        if (from.equals("Select") ||
            to.equals("Select") ||
            from.equals(to)) {

            priceField.setText("");
            return;
        }

        int basePrice = getRoutePrice(from, to);

        int seats = Integer.parseInt(
            (String) seatCombo.getSelectedItem()
        );

        String busType =
            (String) busTypeCombo.getSelectedItem();

        double multiplier = 1.0;

        if (busType.equals("AC")) {
            multiplier = 1.5;
        } else if (busType.equals("Sleeper")) {
            multiplier = 2.0;
        }

        double totalFare =
            basePrice * seats * multiplier;

        priceField.setText(
            "Rs. " + String.format("%.2f", totalFare)
        );
    }

    // ---------------- ROUTE PRICE ----------------

    private int getRoutePrice(
        String from,
        String to
    ) {

        if (from.equals("Salem") &&
            to.equals("Namakkal")) return 25;

        if (from.equals("Salem") &&
            to.equals("Erode")) return 60;

        if (from.equals("Salem") &&
            to.equals("Karur")) return 130;

        if (from.equals("Salem") &&
            to.equals("Chennai")) return 500;

        if (from.equals("Namakkal") &&
            to.equals("Salem")) return 25;

        if (from.equals("Namakkal") &&
            to.equals("Erode")) return 60;

        if (from.equals("Namakkal") &&
            to.equals("Karur")) return 130;

        if (from.equals("Namakkal") &&
            to.equals("Chennai")) return 500;

        if (from.equals("Erode") &&
            to.equals("Salem")) return 60;

        if (from.equals("Erode") &&
            to.equals("Namakkal")) return 80;

        if (from.equals("Erode") &&
            to.equals("Karur")) return 180;

        if (from.equals("Erode") &&
            to.equals("Chennai")) return 500;

        if (from.equals("Karur") &&
            to.equals("Salem")) return 130;

        if (from.equals("Karur") &&
            to.equals("Namakkal")) return 80;

        if (from.equals("Karur") &&
            to.equals("Erode")) return 180;

        if (from.equals("Karur") &&
            to.equals("Chennai")) return 500;

        if (from.equals("Chennai") &&
            to.equals("Salem")) return 500;

        if (from.equals("Chennai") &&
            to.equals("Namakkal")) return 500;

        if (from.equals("Chennai") &&
            to.equals("Erode")) return 500;

        if (from.equals("Chennai") &&
            to.equals("Karur")) return 500;

        return 0;
    }

    // ---------------- BOOK TICKET ----------------

    private void bookTicket() {

        String name =
            nameField.getText().trim();

        String contact =
            contactField.getText().trim();

        String from =
            (String) fromCombo.getSelectedItem();

        String to =
            (String) toCombo.getSelectedItem();

        // Name validation

        if (name.isEmpty()) {

            JOptionPane.showMessageDialog(
                frame,
                "Please enter passenger name."
            );

            return;
        }

        // Contact validation

        if (!contact.matches("\\d{10}")) {

            JOptionPane.showMessageDialog(
                frame,
                "Enter a valid 10 digit contact number."
            );

            return;
        }

        // Location validation

        if (from.equals("Select") ||
            to.equals("Select")) {

            JOptionPane.showMessageDialog(
                frame,
                "Please select From and To locations."
            );

            return;
        }

        // Same location

        if (from.equals(to)) {

            JOptionPane.showMessageDialog(
                frame,
                "From and To cannot be same."
            );

            return;
        }

        // Terms

        if (!termsCheckBox.isSelected()) {

            JOptionPane.showMessageDialog(
                frame,
                "Please accept Terms and Conditions."
            );

            return;
        }

        // Generate Booking ID

        String bookingId =
            "JMSMK-" +
            UUID.randomUUID()
                .toString()
                .substring(0, 8)
                .toUpperCase();

        bookingIdField.setText(bookingId);

        // Gender

        String gender;

        if (maleRadio.isSelected()) {
            gender = "Male";
        } else {
            gender = "Female";
        }

        // Get details

        String busType =
            (String) busTypeCombo.getSelectedItem();

        String timing =
            (String) timingCombo.getSelectedItem();

        String payment =
            (String) paymentCombo.getSelectedItem();

        String numberOfSeats =
            (String) seatCombo.getSelectedItem();

        String travelDate =
            travelDayCombo.getSelectedItem()
            + "/"
            + travelMonthCombo.getSelectedItem()
            + "/"
            + travelYearCombo.getSelectedItem();

        String dob =
            dobDayCombo.getSelectedItem()
            + "/"
            + dobMonthCombo.getSelectedItem()
            + "/"
            + dobYearCombo.getSelectedItem();

        String fare =
            priceField.getText();

        // Create ticket

        String ticket =
            "========================================\n" +
            "          JMSMK TRAVELS\n" +
            "       BUS BOOKING TICKET\n" +
            "========================================\n\n" +

            "Booking ID    : " + bookingId + "\n" +
            "Passenger     : " + name + "\n" +
            "Contact       : " + contact + "\n" +
            "Gender        : " + gender + "\n" +
            "DOB           : " + dob + "\n\n" +

            "From          : " + from + "\n" +
            "To            : " + to + "\n" +
            "Bus Type      : " + busType + "\n" +
            "Bus Timing    : " + timing + "\n" +
            "Travel Date   : " + travelDate + "\n" +
            "No. of Seats  : " + numberOfSeats + "\n" +
            "Payment       : " + payment + "\n" +
            "Total Fare    : " + fare + "\n\n" +

            "========================================\n" +
            "       BOOKING SUCCESSFUL\n" +
            "========================================\n" +
            "        Thank You for Travelling\n" +
            "          with JMSMK Travels!\n";

        // Store booking

        bookings.put(
            bookingId,
            ticket
        );

        // Display ticket

        ticketArea.setText(ticket);

        JOptionPane.showMessageDialog(
            frame,
            "Booking Successful!\n\n" +
            "Booking ID: " + bookingId,
            "Success",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    // ---------------- SAVE TICKET ----------------

    private void saveTicket() {

        if (ticketArea.getText().isEmpty()) {

            JOptionPane.showMessageDialog(
                frame,
                "Please book a ticket first."
            );

            return;
        }

        String bookingId =
            bookingIdField.getText();

        try {

            File file =
                new File(
                    "Ticket_" +
                    bookingId +
                    ".txt"
                );

            FileWriter writer =
                new FileWriter(file);

            writer.write(
                ticketArea.getText()
            );

            writer.close();

            JOptionPane.showMessageDialog(
                frame,
                "Ticket saved successfully!\n" +
                "File: " + file.getName()
            );

        } catch (IOException ex) {

            JOptionPane.showMessageDialog(
                frame,
                "Error saving ticket."
            );
        }
    }

    // ---------------- PRINT TICKET ----------------

    private void printTicket() {

        if (ticketArea.getText().isEmpty()) {

            JOptionPane.showMessageDialog(
                frame,
                "Please generate a ticket first."
            );

            return;
        }

        try {

            boolean complete =
                ticketArea.print();

            if (complete) {

                JOptionPane.showMessageDialog(
                    frame,
                    "Ticket printed successfully."
                );

            } else {

                JOptionPane.showMessageDialog(
                    frame,
                    "Printing cancelled."
                );
            }

        } catch (PrinterException ex) {

            JOptionPane.showMessageDialog(
                frame,
                "Unable to print ticket."
            );
        }
    }

    // ---------------- SEARCH BOOKING ----------------

    private void searchBooking() {

        String id =
            JOptionPane.showInputDialog(
                frame,
                "Enter Booking ID:"
            );

        if (id == null ||
            id.trim().isEmpty()) {

            return;
        }

        String ticket =
            bookings.get(
                id.trim().toUpperCase()
            );

        if (ticket != null) {

            ticketArea.setText(ticket);

            JOptionPane.showMessageDialog(
                frame,
                "Booking found successfully."
            );

        } else {

            JOptionPane.showMessageDialog(
                frame,
                "Booking not found."
            );
        }
    }

    // ---------------- CANCEL BOOKING ----------------

    private void cancelBooking() {

        String id =
            JOptionPane.showInputDialog(
                frame,
                "Enter Booking ID to cancel:"
            );

        if (id == null ||
            id.trim().isEmpty()) {

            return;
        }

        id = id.trim().toUpperCase();

        if (bookings.containsKey(id)) {

            int choice =
                JOptionPane.showConfirmDialog(
                    frame,
                    "Are you sure you want to cancel\n" +
                    "Booking ID: " + id + "?",
                    "Cancel Booking",
                    JOptionPane.YES_NO_OPTION
                );

            if (choice ==
                JOptionPane.YES_OPTION) {

                bookings.remove(id);

                ticketArea.setText("");

                bookingIdField.setText("");

                JOptionPane.showMessageDialog(
                    frame,
                    "Booking cancelled successfully."
                );
            }

        } else {

            JOptionPane.showMessageDialog(
                frame,
                "Booking ID not found."
            );
        }
    }

    // ---------------- CLEAR FORM ----------------

    private void clearForm() {

        nameField.setText("");
        contactField.setText("");
        bookingIdField.setText("");
        priceField.setText("");

        fromCombo.setSelectedIndex(0);
        toCombo.setSelectedIndex(0);

        seatCombo.setSelectedIndex(0);
        busTypeCombo.setSelectedIndex(0);
        timingCombo.setSelectedIndex(0);
        paymentCombo.setSelectedIndex(0);

        maleRadio.setSelected(true);

        termsCheckBox.setSelected(false);

        ticketArea.setText("");

        nameField.requestFocus();
    }

    // ---------------- MAIN METHOD ----------------

    public static void main(String[] args) {

        new BusBookAdvanced();
    }
}

