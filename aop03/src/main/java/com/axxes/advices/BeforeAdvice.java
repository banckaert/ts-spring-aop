package com.axxes.advices;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BeforeAdvice {

  Logger logger = LoggerFactory.getLogger(BeforeAdvice.class);

  private boolean beforeCalled = false;

  public void reset() {
    beforeCalled = false;
  }

  public boolean isBeforeCalled() {
    return beforeCalled;
  }

  // FIXME Add Advice
  public void entering(JoinPoint joinPoint) {
    beforeCalled = true;
    logger.trace("entering "
        + joinPoint.getStaticPart().getSignature().toString());
  }

}
