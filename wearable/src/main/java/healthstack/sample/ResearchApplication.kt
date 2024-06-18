package healthstack.sample

import android.app.Application
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import dagger.hilt.android.HiltAndroidApp
import healthstack.wearable.support.worker.setWearableDataSync
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltAndroidApp
class ResearchApplication : Application(), Configuration.Provider {
    @Inject
    lateinit var workerFactory: HiltWorkerFactory

    override fun getWorkManagerConfiguration() =
        Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()

    override fun onCreate() {
        super.onCreate()
        setWearableDataSync(this, 2, TimeUnit.HOURS)
    }
}
