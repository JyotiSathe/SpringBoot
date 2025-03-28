Spring Boot Training

# Vault Steps

## Download URL : https://developer.hashicorp.com/vault/install

## set vault server PATH in Environment Variables (System Variables)

## Start vault server
### Step1: vault server --config=vault.conf
C:\Users\User\Downloads\vault_1.19.0_windows_amd64>vault server --config=vault.conf
- Access vault server on Chrome 
  http://localhost:8200/ui/vault/init
- Set Key Shares as 5, Key Threshold as 2 INITIALIZE
- Then Download the keys, it will download json file [vault-cluster-vault-2025-03-20T05_54_12.136Z.json](vault-cluster-vault-2025-03-20T05_54_12.136Z.json)
- Continue to unseal
- Give 2 keys from `keys_base64` one by one from json
- Give `root_token` from json

### Below steps (2,3,4) only one time
### Step 2: set VAULT_ADDR=http://localhost:8200
### Step 3: set VAULT_TOKEN=`root_token` from json
### Step 4: vault secrets enable -path=secret/ kv

![img.png](img.png)

### Reload vault server UI `http://localhost:8200/ui/vault/dashboard` and pass `root_token` again.

### Step 5: Create secrete from Secret Engines
- Path -> mysqlsecret
- Username -> root
- Password -> `MYSQL DB password`

If this is not working create secret using below steps:
vault kv put secret/mysqlsecret mysqlusername=root password=Cloud@123$

# DB steps
### Step 1: create new git repo with all properties file (files from [db-config-files](db-config-files)) as per environment
### Step 2: create `siemensdevaccountdb`, `siemensprodaccountdb`, `siemensqaaccountdb`, `siemenstestaccountdb` schemas in mysql workbench

# Config Server Setup
### another repo configserverdemo

# Enable vault communication
### Step 1: bootstrap.properties
- update vault token as per `root_token`

#

# Future
```docker cp vault.json boa-vault:/vault/config```