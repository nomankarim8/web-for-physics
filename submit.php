<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $name = $_POST["name"];
    $dob = $_POST["dob"];
    $medicalHistory = $_POST["medicalHistory"];
    $familyHistory = $_POST["familyHistory"];
    $lifestyleFactors = $_POST["lifestyleFactors"];

    // Construct the data string
    $data = "Name: $name\nDate of Birth: $dob\nMedical History:\n$medicalHistory\nFamily History:\n$familyHistory\nLifestyle Factors:\n$lifestyleFactors\n\n";

    // Save data to a text file (append mode)
    $file = fopen("patient_data.txt", "a");
    fwrite($file, $data);
    fclose($file);

    echo "Data submitted successfully!";
} else {
    echo "Invalid request.";
}
?>
