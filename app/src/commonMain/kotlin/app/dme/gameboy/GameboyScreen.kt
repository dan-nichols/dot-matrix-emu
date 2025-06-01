package app.dme.gameboy

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import core.Gameboy

@Composable
fun GameboyScreen(vm: GameboyViewModel = viewModel { GameboyViewModel(Gameboy()) }) {

    val state by vm.state.collectAsStateWithLifecycle()

    Spacer(modifier = Modifier.height(16.dp))
    Text(text = "Device loaded")
    Spacer(modifier = Modifier.height(16.dp))

    LcdDisplay(state.xy, state.backgroundColor)

//    var cyclesPerSecond by remember { mutableStateOf(0) }
//    var lastCycleCount by remember { mutableStateOf(1) }
//
//    val cyclesFlow: Flow<Int> = remember(bootRom) {
//        if (bootRom.isNotEmpty()) {
//            Gameboy().main()
//                .sample(1000)
//                .onEach { cycles ->
//                    cyclesPerSecond = cycles - lastCycleCount
//                    lastCycleCount = cycles
//
//                    println(cycles)
//                }
//        } else {
//            flowOf(0)
//        }
//    }
//    val cycles by cyclesFlow.collectAsStateWithLifecycle(0)
//
//    Text(text = "${cyclesPerSecond / 1_000_000} MHz")
//    Text(text = "${cyclesPerSecond / 1_000} KHz")
//    Text(text = "$cyclesPerSecond Hz")
}
