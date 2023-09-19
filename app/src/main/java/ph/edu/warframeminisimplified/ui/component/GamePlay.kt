package ph.edu.warframeminisimplified.ui.component

import CorpusAmalgamHeqet
import CorpusGlaxionMOA
import CorpusTech
import Enemy
import PrimaryWeapon
import SecondaryWeapon
import Tenno
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.textInputServiceFactory
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ph.edu.warframeminisimplified.ui.theme.WarframeMiniSimplifiedTheme
import kotlin.random.Random


@Composable
fun ComposableMoveButtons(
    primaryWeapon: PrimaryWeapon,
    secondaryWeapon: SecondaryWeapon
) {
//    val enemies: List<Enemy> = listOf(
//        CorpusTech,
//        CorpusAmalgamHeqet,
//        CorpusGlaxionMOA,
//        CorpusGlaxionMOA,
//        CorpusGlaxionMOA,
//        CorpusAmalgamHeqet
//    )
    var enemies by remember{ mutableStateOf(CorpusTech)}
    var choice by remember { mutableStateOf(null) }
    //val aliveEnemies = enemies.filter { it.alive() }
    //var firstAliveEnemy = aliveEnemies.first()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = enemies.name,
                fontWeight = FontWeight.Bold
            )
            Text(text = "Shields: ${enemies.currentShield}/${enemies.shieldEnemy} HP: ${enemies.currentHP}/${enemies.healthEnemy}")
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = primaryWeapon.name)
                Button(
                    onClick = {
                        if (enemies.alive()) {
                            val enemyMove = Random.nextInt(1, 101)
                            enemies = tenno.attack(enemies, primaryWeapon)
                            if ((enemyMove in 1..50) && enemies.alive()) {
                                tenno = enemies.attack(
                                    tenno,
                                    enemies.enemyWeapon
                                )
                            } else if ((enemyMove in 51..101) && enemies.alive()) {
                                enemies = enemies.shieldRegen()
                            }
                        }
                    }
                ) {
                    Text(text = "${primaryWeapon.baseDamage * primaryWeapon.multiShot} - ${primaryWeapon.fireRate * (primaryWeapon.baseDamage * primaryWeapon.multiShot * (3 + primaryWeapon.criticalDamage))}")
                }
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = secondaryWeapon.name)

                Button(
                    onClick = {
                        //val aliveEnemies = enemies.filter { it.alive() }
                        // val firstAliveEnemy = aliveEnemies.first()
                        if (enemies.alive()) {
                            val enemyMove = Random.nextInt(1, 101)
                            enemies = tenno.attack(enemies, secondaryWeapon)
                            if ((enemyMove in 1..50) && enemies.alive()) {
                                tenno = enemies.attack(tenno, enemies.enemyWeapon)
                            } else if ((enemyMove in 51..101) && enemies.alive()) {
                                enemies = enemies.shieldRegen()
                            }
                        }
                    }
                ) {
                    Text(text = "${secondaryWeapon.baseDamage * secondaryWeapon.multiShot} - ${secondaryWeapon.fireRate * (secondaryWeapon.baseDamage * secondaryWeapon.multiShot * (3 + secondaryWeapon.criticalDamage))}")
                }
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Dodge")
                Button(
                    onClick = {
                        //val aliveEnemies = enemies.filter { it.alive() }
                        //val firstAliveEnemy = aliveEnemies.first()
                        if (enemies.alive()) {
                            val dodgeMove = tenno.dodgeAttack(tenno.speedTenno, enemies)
                            if (dodgeMove) {
                                //println("${tenno.name} successfully dodged ${firstAliveEnemy.name}'s attack!\nNo damage received!")
                                tenno = tenno.tennoShieldRegen()
                                //println("${tenno.name} restoring shields to full...")
                            } else {
                                //println("${tenno.name} failed to dodge the attack!")
                                tenno = enemies.attack(tenno, enemies.enemyWeapon)
                            }
                        }
                    }
                ) {
                    Text(text = "${tenno.speedTenno}%")
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Text(
                text = "${tenno.name}",
                fontWeight = FontWeight.Bold
            )
        }
        Row {
            Text(text = "Shields: ${tenno.shield}/${tenno.shieldTenno} Health: ${tenno.health}/${tenno.healthTenno} ")
        }
    }
}


//@Preview
//@Composable
//fun ComposableMoveOptionsPreview() {
//    WarframeMiniSimplifiedTheme {
//        val tenno = remember { mutableStateOf(Tenno("Mirage", 90, 25, 35, Random.nextInt(75, 80), 1, 0, 100)) }
//        val primarywep = PrimaryWeapon("Braton", 7, 2, 3, 15, 2, 80, 5, 2)
//        val secondarywep = SecondaryWeapon("Lato", 5, 1, 3, 30, 4, 100, 10, 1)
//        Column {
//            ComposableMoveButtons(tenno, primarywep, secondarywep)
//            //ComposableGameplay()
//        }
//    }
//}
