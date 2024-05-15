package com.example.introductionjetpack

import android.app.Notification.Action
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.introductionjetpack.ui.theme.DebugButtonColors
import com.example.introductionjetpack.ui.theme.ErrorButtonColors
import com.example.introductionjetpack.ui.theme.InfoButtonColors
import com.example.introductionjetpack.ui.theme.IntroductionJetPackTheme
import com.example.introductionjetpack.ui.theme.WarningButtonColors
import java.lang.RuntimeException

const val TAG = "TestAndroid"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntroductionJetPackTheme {
                    // A surface container using the 'background' color from the theme
                    App()
                }
            }
        }
}

@Composable
private fun App() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ){
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Greeting("JetPack")
            ActionButton(
                text = "Debug",
                buttonColors = DebugButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                /* Ação no Botão */
                Log.d(TAG, "App: Clicou em DEBUG!")
            }
            ActionButton(
                text = "Info",
                buttonColors = InfoButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                /* Ação no Botão */
                Log.i(TAG, "App: Clicou em INFO!")
            }
            ActionButton(
                text = "Warning",
                buttonColors = WarningButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                Log.w(TAG, "App; Clicou em Warning")
            }
            ActionButton(
                text = "Error",
                buttonColors = ErrorButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                try {
                    throw RuntimeException("Clicou em Error")
                }catch(ex: Exception){
                    Log.e(TAG, "App; Clicou em Error")
                }
            }
        }
    }
}

@Composable
fun ActionButton(
    text: String,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(),
    modifier: Modifier = Modifier,
    block: () -> Unit
) {
    ElevatedButton(
        onClick = block,
        shape = RoundedCornerShape(5.dp),
        colors = buttonColors,
        modifier = Modifier
    )
    {
        Text(text = text)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier){
    val nome = "PAM"
    Text(
        text = "Aula de $nome!",
        style = MaterialTheme.typography.bodyLarge.copy(
            fontWeight = FontWeight.Bold
        ),
        color = MaterialTheme.colorScheme.secondary
    )
}

@Preview(showBackground = true, widthDp = 150, heightDp = 200)
@Composable
fun AppPreview(){
    IntroductionJetPackTheme {
        App()
    }
}

@Preview
@Composable
fun ActionButtonPreview(){
    ActionButton(text = "Cadastrar"){

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IntroductionJetPackTheme {
        Greeting("JetPack")
    }
}