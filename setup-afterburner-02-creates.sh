#!/usr/bin/env bash
az group create --name $GROUP --location westeurope
az configure -d group=$GROUP location=westeurope
az acr create --admin-enabled --name $REGISTRY_NAME --sku Basic