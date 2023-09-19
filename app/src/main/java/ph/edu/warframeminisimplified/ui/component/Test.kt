package ph.edu.warframeminisimplified.ui.component

import PrimaryWeapon
import SealedRangedWeapons
import SealedWarframeChoices
import SecondaryWeapon
import Tenno
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ph.edu.warframeminisimplified.ui.theme.WarframeMiniSimplifiedTheme
import kotlin.random.Random

enum class Screen {
    Start,
    Gameplay,
    Result
}
var confirm by (mutableStateOf(false))

var userWarframeInput: SealedWarframeChoices by mutableStateOf(SealedWarframeChoices.EXCALIBUR)

var excalTenno = Tenno("Excalibur", 100, 20, 50, Random.nextInt(50, 75), 1, 0,100)

var tenno by mutableStateOf(excalTenno)

var primaryWeapon: PrimaryWeapon by mutableStateOf(PrimaryWeapon.BRATON)

var secondaryWeapon: SecondaryWeapon by mutableStateOf(SecondaryWeapon.LATO)

val warframeChoices = listOf(
    SealedWarframeChoices.EXCALIBUR,
    SealedWarframeChoices.MAG,
    SealedWarframeChoices.VOLT,
    SealedWarframeChoices.BANSHEE,
    SealedWarframeChoices.NOVA,
    SealedWarframeChoices.MIRAGE,
    SealedWarframeChoices.PROTEA,
    SealedWarframeChoices.WUKONG,
)
val primaryWeaponChoices = listOf(
    PrimaryWeapon.BRATON,
    PrimaryWeapon.PARIS,
    PrimaryWeapon.FLUXRIFLE,
    PrimaryWeapon.HEK,
    PrimaryWeapon.KOMOREX,
    PrimaryWeapon.GLAXION,
)
val secondaryWeaponChoices = listOf(
    SecondaryWeapon.LATO,
    SecondaryWeapon.MAGNUS,
    SecondaryWeapon.DETRON,
    SecondaryWeapon.BRAKK,
    SecondaryWeapon.STUG,
)

@Preview
@Composable
fun TestPreview() {
    WarframeMiniSimplifiedTheme {
        Column {
            ComposableWarframe()
            ComposablePrimaryWeapon()
            ComposableSecondaryWeapon()
        }
    }
}


@Composable
fun ComposableWarframe() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "Choose your Warframe")
        Row {
            Column {
                for (warframe in warframeChoices) {
                    val containerColor by animateColorAsState(
                        if (userWarframeInput == warframe) MaterialTheme.colorScheme.primary
                        else MaterialTheme.colorScheme.primaryContainer
                    )
                    Button(
                        onClick = {
                            userWarframeInput = warframe
                            tenno = Tenno(
                                name = warframe.name,
                                healthTenno = warframe.healthTenno,
                                armorTenno = warframe.armorTenno,
                                shieldTenno = warframe.shieldTenno,
                                speedTenno = warframe.speedTenno,
                                levelTenno = warframe.levelTenno,
                                currentXPTenno = warframe.currentXPTenno,
                                xpCapTenno = warframe.xpCapTenno
                            )
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = containerColor,
                            contentColor = contentColorFor(containerColor),
                        ),
                        modifier = Modifier.fillMaxWidth(0.5f)

                    ) {
                        Text(text = warframe.name)
                    }
                }
            }
        }
    }

}

@Composable
fun ComposablePrimaryWeapon() {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ){
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Choose Your Primary Weapon")
        Row {
            Column {
                for (primaryweapon in primaryWeaponChoices) {
                    val containerColor by animateColorAsState(
                        if (primaryWeapon == primaryweapon) MaterialTheme.colorScheme.primary
                        else MaterialTheme.colorScheme.primaryContainer
                    )

                    Button(
                        onClick = {
                            primaryWeapon = PrimaryWeapon(
                                name = primaryweapon.name,
                                baseDamage = primaryweapon.baseDamage,
                                multiShot = primaryweapon.multiShot,
                                fireRate = primaryweapon.fireRate,
                                criticalChance = primaryweapon.criticalChance,
                                criticalDamage = primaryweapon.criticalDamage,
                                weaponAccuracy = primaryweapon.weaponAccuracy,
                                weaponRecoil = primaryweapon.weaponRecoil,
                                weaponRange = primaryweapon.weaponRange
                            )
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = containerColor,
                            contentColor = contentColorFor(containerColor),
                        ),
                        modifier = Modifier.fillMaxWidth(0.5f)
                    ) {
                        Text(text = primaryweapon.name)
                    }
                }
            }
        }
    }

}

@Composable
fun ComposableSecondaryWeapon() {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ){
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Choose Your Secondary Weapon")
        Row {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                for (secondaryweapon in secondaryWeaponChoices) {
                    val containerColor by animateColorAsState(
                        if (secondaryWeapon == secondaryweapon) MaterialTheme.colorScheme.primary
                        else MaterialTheme.colorScheme.primaryContainer
                    )
                    Button(
                        onClick = {
                            secondaryWeapon = SecondaryWeapon(
                                name = secondaryweapon.name,
                                baseDamage = secondaryweapon.baseDamage,
                                multiShot = secondaryweapon.multiShot,
                                fireRate = secondaryweapon.fireRate,
                                criticalChance = secondaryweapon.criticalChance,
                                criticalDamage = secondaryweapon.criticalDamage,
                                weaponAccuracy = secondaryweapon.weaponAccuracy,
                                weaponRecoil = secondaryweapon.weaponRecoil,
                                weaponRange = secondaryweapon.weaponRange
                            )
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = containerColor,
                            contentColor = contentColorFor(containerColor),
                        ),
                        modifier = Modifier.fillMaxWidth(0.5f)
                    ) {
                        Text(text = secondaryweapon.name)
                    }
                }
            }
        }
    }
}

@Composable
fun ConfirmButton() {
    Column {
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = { confirm = true },
            ) {
            Text(text = "Confirm")
        }
    }

}

//@Composable
//fun holders(tenno: Tenno, primaryWeapon: PrimaryWeapon, secondaryWeapon: SecondaryWeapon) {
//    ComposableMoveButtons(tenno.value, primaryWeapon, secondaryWeapon)
//}
