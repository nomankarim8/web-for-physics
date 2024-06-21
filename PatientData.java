public class PatientData {
    private String name;
    private String dob;
    private String geneticData;
    private String medicalHistory;
    private String familyHistory;
    private String lifestyleFactors;

    // Constructors, getters, setters, and other methods

    // Add methods to save and process patient data
    public void saveToFile() {
        String data = "Name: " + name + "\nDate of Birth: " + dob + "\nGenetic Data: " + geneticData + "\nMedical History:\n"
                + medicalHistory + "\nFamily History:\n" + familyHistory + "\nLifestyle Factors:\n" + lifestyleFactors + "\n\n";

        try (FileWriter writer = new FileWriter("patient_data.txt", true)) {
            writer.write(data);
            System.out.println("Data saved successfully!");
        } catch (IOException e) {
            System.err.println("Error saving data: " + e.getMessage());
        }
    }
}
import java.util.Map;

public class SubmitHandler {
    public static void handleSubmit(Map<String, String> formData) {
        PatientData patientData = new PatientData();
        patientData.setName(formData.get("name"));
        patientData.setDob(formData.get("dob"));
        patientData.setGeneticData(formData.get("geneticData"));
        patientData.setMedicalHistory(formData.get("medicalHistory"));
        patientData.setFamilyHistory(formData.get("familyHistory"));
        patientData.setLifestyleFactors(formData.get("lifestyleFactors"));

        patientData.saveToFile();
    }
}
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PatientData {
    // ... (other properties and methods)

    // Method to save data to a database
    public void saveToDatabase() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/your_database_name";
        String username = "your_username";
        String password = "your_password";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            String query = "INSERT INTO patient_data (name, dob, genetic_data, medical_history, family_history, lifestyle_factors) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, name);
                statement.setString(2, dob);
                statement.setString(3, geneticData);
                statement.setString(4, medicalHistory);
                statement.setString(5, familyHistory);
                statement.setString(6, lifestyleFactors);
                statement.executeUpdate();
                System.out.println("Data saved to database successfully!");
            }
        } catch (SQLException e) {
            System.err.println("Error saving data to database: " + e.getMessage());
        }
    }
}
import java.util.Map;

public class SubmitHandler {
    public static void handleSubmit(Map<String, String> formData) {
        PatientData patientData = new PatientData();
        patientData.setName(formData.get("name"));
        patientData.setDob(formData.get("dob"));
        patientData.setGeneticData(formData.get("geneticData"));
        patientData.setMedicalHistory(formData.get("medicalHistory"));
        patientData.setFamilyHistory(formData.get("familyHistory"));
        patientData.setLifestyleFactors(formData.get("lifestyleFactors"));

        // Save to database instead of file
        patientData.saveToDatabase();
    }
}
