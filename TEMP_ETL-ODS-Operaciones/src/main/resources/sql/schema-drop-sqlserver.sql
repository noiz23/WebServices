-- Autogenerated: do not edit this file

IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[BATCH_STEP_EXECUTION_CONTEXT]') AND TYPE IN (N'U'))
DROP TABLE [dbo].[BATCH_STEP_EXECUTION_CONTEXT]

IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[BATCH_JOB_EXECUTION_CONTEXT]') AND TYPE IN (N'U'))
DROP TABLE  [dbo].[BATCH_JOB_EXECUTION_CONTEXT] ;

IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[BATCH_STEP_EXECUTION]') AND TYPE IN (N'U'))
DROP TABLE  [dbo].[BATCH_STEP_EXECUTION] ;

IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[BATCH_JOB_EXECUTION_PARAMS]') AND TYPE IN (N'U'))
DROP TABLE  [dbo].[BATCH_JOB_EXECUTION_PARAMS] ;

IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[BATCH_JOB_EXECUTION]') AND TYPE IN (N'U'))
DROP TABLE  [dbo].[BATCH_JOB_EXECUTION] ;

IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[BATCH_JOB_INSTANCE]') AND TYPE IN (N'U'))
DROP TABLE  [dbo].[BATCH_JOB_INSTANCE] ;

IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[BATCH_STEP_EXECUTION_SEQ]') AND TYPE IN (N'U'))
DROP TABLE  [dbo].[BATCH_STEP_EXECUTION_SEQ] ;

IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[BATCH_JOB_EXECUTION_SEQ]') AND TYPE IN (N'U'))
DROP TABLE  [dbo].[BATCH_JOB_EXECUTION_SEQ] ;

IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[BATCH_JOB_SEQ]') AND TYPE IN (N'U'))
DROP TABLE  [dbo].[BATCH_JOB_SEQ] ;
