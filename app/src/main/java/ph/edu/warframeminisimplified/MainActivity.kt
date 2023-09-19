package ph.edu.warframeminisimplified

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ph.edu.warframeminisimplified.ui.component.ComposableMoveButtons
import ph.edu.warframeminisimplified.ui.component.ComposablePrimaryWeapon
import ph.edu.warframeminisimplified.ui.component.ComposableSecondaryWeapon
import ph.edu.warframeminisimplified.ui.component.ComposableWarframe
import ph.edu.warframeminisimplified.ui.component.ConfirmButton
import ph.edu.warframeminisimplified.ui.component.confirm
import ph.edu.warframeminisimplified.ui.component.primaryWeapon
import ph.edu.warframeminisimplified.ui.component.secondaryWeapon
import ph.edu.warframeminisimplified.ui.component.tenno
import ph.edu.warframeminisimplified.ui.theme.WarframeMiniSimplifiedTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WarframeMiniSimplifiedTheme {
                if(confirm == false) {
                    Column(
                        modifier = Modifier.verticalScroll(rememberScrollState()),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        ComposableWarframe()
                        ComposablePrimaryWeapon()
                        ComposableSecondaryWeapon()
                        ConfirmButton()
                    }
                }
                else{
                    Column(
                        modifier = Modifier.verticalScroll(rememberScrollState()),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        ComposableMoveButtons(primaryWeapon, secondaryWeapon )
                    }
                }
            }
        }
    }
}

