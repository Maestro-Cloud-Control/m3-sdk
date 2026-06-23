/*
 * Copyright 2023 Maestro Cloud Control LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.maestro3.sdk.v3.model.ownership;

public enum ResourceType {
    UNKNOWN,

    // Compute resources
    INSTANCE, // Virtual machines, EC2, VM, Compute instances
    FUNCTION, // Serverless functions: Lambda, Cloud Functions, Azure Functions
    CONTAINER_SERVICE, // ECS services, AKS, container orchestration services
    CONTAINER_REGISTRY, // ECR, ACR, GCR
    IMAGE, // Machine images: AMI, VM images, container images

    // Storage resources
    VOLUME, // Block storage: EBS, disks
    BUCKET, // Object storage: S3, Blob Storage, Cloud Storage
    FILE_SYSTEM, // Network file systems: EFS, FSx, Azure Files
    SNAPSHOT, // Snapshots of volumes and disks
    BACKUP, // Backup vaults, plans, and backup storage

    // Database resources
    DATABASE, // All database types: RDS, DynamoDB, CosmosDB, SQL, NoSQL
    CACHE, // Cache services: ElasticCache, Redis, Memcached, DAX

    // Networking resources
    VPC, // Virtual networks: VPC, VNet
    SUBNET, // Subnets within virtual networks
    SECURITY_GROUP, // Security groups and firewall rules
    LOAD_BALANCER, // Load balancers: ELB, ALB, NLB, Azure LB
    NETWORK_INTERFACE, // ENI, network interfaces
    NETWORK_GATEWAY, // NAT Gateway, Internet Gateway, VPN Gateway, Transit Gateway
    IP_ADDRESS, // Elastic IPs, Public IPs, static addresses
    DNS_ZONE, // Route53 zones, DNS zones
    CDN, // CloudFront, CDN distributions
    REGION, // Regions, zones
    ZONE, // Zones

    // Security & Identity resources
    IAM_USER, // IAM users, service principals
    IAM_ROLE, // IAM roles, managed identities
    IAM_GROUP, // IAM groups
    IAM_POLICY, // IAM policies, role definitions
    ENCRYPTION_KEY, // KMS keys, Key Vault keys
    SECRET, // Secrets Manager, Key Vault secrets, Secret Manager
    CERTIFICATE, // SSL/TLS certificates: ACM, Key Vault certs

    // Application & Integration resources
    API_GATEWAY, // API Gateway, API Management
    MESSAGE_QUEUE, // SQS, SNS, EventHub, Kafka, PubSub, Service Bus
    EVENT_BUS, // EventBridge, Event Grid
    CONFIG, // Configuration, App Configuration

    // Management & Orchestration resources
    K8S_CLUSTER, // EKS, AKS, GKE clusters
    AUTOSCALING_GROUP, // Auto Scaling Groups, Scale Sets

    // Infrastructure as Code
    TERRAFORM_TEMPLATE, // CloudFormation templates, ARM templates
    TERRAFORM_STACK, // CloudFormation stacks, deployed templates
    TEMPLATE, // Generic templates
    STACK, // Generic stacks

    // Organization resources
    TENANT, // AWS accounts, Azure subscriptions, GCP projects

    // Monitoring & Logging resources
    LOG_GROUP, // CloudWatch log groups, Log Analytics workspaces
    ;

    @Override
    public String toString() {
        return this.name();
    }

}
