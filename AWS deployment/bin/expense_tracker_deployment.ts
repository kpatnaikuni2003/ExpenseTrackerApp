#!/usr/bin/env node
import * as cdk from 'aws-cdk-lib';
import { ExpenseTrackerDeploymentStack } from '../lib/expense_tracker_deployment-stack';
import { ExpenseTrackerServices } from '../lib/expense_services-stack';
import { ExpenseBackendServices } from '../lib/expense_backend_services-stack';

const app = new cdk.App();


// Define the AWS environment
const env = {
  account: process.env.CDK_DEFAULT_ACCOUNT,
  region: process.env.CDK_DEFAULT_REGION,
};

const vpcStack=new ExpenseTrackerDeploymentStack(app, 'ExpenseTrackerDeploymentStack', {
  env,
});


// Deploy MySQL and Kafka stack
const mysqlAndKafkaStack = new ExpenseTrackerServices(app, 'ExpenseTrackerServicesStack', {
  env,  // Expense Tracker deps 
});

const backendServices = new ExpenseBackendServices(app, 'ExpenseBackendServices', {
  env // Expense tracker backend services
})