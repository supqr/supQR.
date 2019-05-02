package com.coderbunker.supqr.util;

import lombok.RequiredArgsConstructor;

import javax.inject.Inject;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class JobExecutor {

	private final Runnable runnable;
	private final int delay;
	private final TimeUnit timeUnit;
	private ScheduledFuture<?> scheduledFuture;

	public void schedule () {
		scheduledFuture = Executors
			.newSingleThreadScheduledExecutor()
			.scheduleWithFixedDelay(runnable, 0, delay, timeUnit);
	}

	public void stop () {
		scheduledFuture.cancel(false);
	}

}
