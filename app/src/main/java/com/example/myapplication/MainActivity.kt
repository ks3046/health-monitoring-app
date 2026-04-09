package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment  // <-- Add this import
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                HealthRecordScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HealthRecordScreen() {
    var bloodPressure by remember { mutableStateOf("") }
    var heartRate by remember { mutableStateOf("") }
    var temperature by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var medicalHistory by remember { mutableStateOf("") }
    var allergies by remember { mutableStateOf("") }
    var currentMedications by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("My Health Record") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Vitals Section
            Text(
                text = "Vital Signs",
                style = MaterialTheme.typography.headlineSmall
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                OutlinedTextField(
                    value = bloodPressure,
                    onValueChange = { bloodPressure = it },
                    label = { Text("BP (mmHg)") },
                    modifier = Modifier.weight(1f)
                )
                OutlinedTextField(
                    value = heartRate,
                    onValueChange = { heartRate = it },
                    label = { Text("Heart Rate") },
                    modifier = Modifier.weight(1f)
                )
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                OutlinedTextField(
                    value = temperature,
                    onValueChange = { temperature = it },
                    label = { Text("Temp (°C)") },
                    modifier = Modifier.weight(1f)
                )
                OutlinedTextField(
                    value = weight,
                    onValueChange = { weight = it },
                    label = { Text("Weight (kg)") },
                    modifier = Modifier.weight(1f)
                )
            }

            // Medical History
            Text(
                text = "Medical History",
                style = MaterialTheme.typography.headlineSmall
            )
            OutlinedTextField(
                value = medicalHistory,
                onValueChange = { medicalHistory = it },
                label = { Text("Past illnesses, surgeries") },
                modifier = Modifier.fillMaxWidth(),
                maxLines = 3
            )

            // Allergies
            Text(
                text = "Allergies",
                style = MaterialTheme.typography.headlineSmall
            )
            OutlinedTextField(
                value = allergies,
                onValueChange = { allergies = it },
                label = { Text("Drugs, foods, etc.") },
                modifier = Modifier.fillMaxWidth(),
                maxLines = 2
            )

            // Current Medications
            Text(
                text = "Current Medications",
                style = MaterialTheme.typography.headlineSmall
            )
            OutlinedTextField(
                value = currentMedications,
                onValueChange = { currentMedications = it },
                label = { Text("Drug names & dosage") },
                modifier = Modifier.fillMaxWidth(),
                maxLines = 3
            )

            // Save Button
            Button(
                onClick = { /* Save to database */ },
                modifier = Modifier.align(Alignment.End)  // <-- Now works with proper import
            ) {
                Text("Save Health Record")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HealthRecordPreview() {
    MyApplicationTheme {
        HealthRecordScreen()
    }
}