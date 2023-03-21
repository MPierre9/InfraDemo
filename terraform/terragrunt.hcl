remote_state {
  backend = "s3"
  config = {
    bucket         = "tf-state-2023"
    key            = "eks-cluster/terraform.tfstate"
    region         = "us-east-1"
    encrypt        = true
    dynamodb_table = "tf-state-lock"
  }
}