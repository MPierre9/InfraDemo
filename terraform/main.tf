provider "aws" {
  region = "us-east-1"
}

terraform {
  backend "s3" {}
}

locals {
  cluster_name = "game-infra"
}

module "vpc" {
  source  = "terraform-aws-modules/vpc/aws"
  version = "3.19.0"

  name               = local.cluster_name
  cidr               = "10.0.0.0/16"
  azs                = ["us-east-1a", "us-east-1b", "us-east-1c"]
  private_subnets    = ["10.0.1.0/24", "10.0.2.0/24", "10.0.3.0/24"]
  public_subnets     = ["10.0.101.0/24", "10.0.102.0/24", "10.0.103.0/24"]
  enable_nat_gateway = true
  single_nat_gateway = true
}

module "eks" {
  source  = "terraform-aws-modules/eks/aws"
  version = "19.10.1"

  cluster_name = local.cluster_name
  subnet_ids   = module.vpc.private_subnets

  tags = {
    Terraform   = "true"
    Environment = "dev"
  }

  vpc_id = module.vpc.vpc_id

  eks_managed_node_groups = {
    default = {
      desired_capacity = 1
      max_capacity     = 2
      min_capacity     = 1
      instance_types   = ["t3.small"]
      disk_size        = 20
      key_name         = "mpierre-2023"
    }
  }
}
