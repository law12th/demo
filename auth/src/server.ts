import { app } from "./app";
import cluster from "cluster";
import os from "os";
import { logger } from "@4pd/shared";

const totalCPUs = os.cpus().length;

if (!cluster.isWorker) {
	logger.info(`Number of CPUs: ${totalCPUs}`);

	for (let i = 0; i < totalCPUs; i++) {
		cluster.fork();
	}

	cluster
		.on("online", (worker) => {
			logger.info(`worker_id: ${worker.id} PID: ${worker.process.pid}`);
		})
		.on("exit", (worker) => {
			logger.info(
				`worker_id: ${worker.id} PID: ${worker.process.pid} exited`
			);
			logger.info("new worker forked");
			cluster.fork();
		});
} else {
	app.listen(5000, () => {
		logger.info(`server listening on port 5000`);
	}).on("error", (err) => {
		logger.error(`server failed: ${err}`);
	});
}
