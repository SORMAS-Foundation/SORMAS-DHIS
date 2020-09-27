
#!/bin/bash

ROOT_PREFIX=
USER_NAME=payara

PAYARA_HOME=${ROOT_PREFIX}/opt/payara5
DOMAINS_HOME=${ROOT_PREFIX}/opt/domains
TEMP_DIR=${ROOT_PREFIX}/opt/${DOMAIN_NAME}/temp

DEPLOY_PATH=/tmp/${DOMAIN_NAME}
SORMAS2SORMAS_DIR=${ROOT_PREFIX}/opt/sormas2dhis

DOMAIN_DIR=${DOMAINS_HOME}/${DOMAIN_NAME}
LOG_FILE_PATH=${DOMAIN_DIR}/logs
LOG_FILE_NAME=server_update_`date +"%Y-%m-%d_%H-%M-%S"`.log



mkdir -p ${PAYARA_HOME}
mkdir -p ${DOMAINS_HOME}
mkdir -p ${DEPLOY_PATH}

mkdir -p ${SORMAS2SORMAS_DIR}

  pushd ${DEPLOY_PATH}
  wget ${SORMAS_URL}/${SORMAS-DHIS_VERSION} -O ${DOMAIN_NAME}.zip
  unzip ${DOMAIN_NAME}.zip
  rm ${DOMAIN_NAME}.zip
  popd



# Setting ASADMIN_CALL and creating domain
echo "Creating domain for Payara..."
${PAYARA_HOME}/bin/asadmin create-domain --domaindir ${DOMAINS_HOME} --portbase ${PORT_BASE} --nopassword --template ${PAYARA_HOME}/glassfish/common/templates/gf/production-domain.jar "${DOMAIN_NAME}"
ASADMIN="${PAYARA_HOME}/bin/asadmin --port ${PORT_ADMIN}"

chown -R ${USER_NAME}:${USER_NAME} ${PAYARA_HOME}

${PAYARA_HOME}/bin/asadmin start-domain --domaindir ${DOMAINS_HOME} ${DOMAIN_NAME}

echo "Configuring domain and database connection..."

# General domain settings
${ASADMIN} delete-jvm-options -Xms2G
${ASADMIN} delete-jvm-options -Xmx2G
${ASADMIN} create-jvm-options -Xmx4096m

${ASADMIN} set configs.config.server-config.admin-service.das-config.autodeploy-enabled=true
${ASADMIN} set configs.config.server-config.admin-service.das-config.dynamic-reload-enabled=true

# Set protocol in redirects according to X-Forwarded-Proto (set by reverse proxy)
${ASADMIN} set server.network-config.protocols.protocol.http-listener-1.http.scheme-mapping=X-Forwarded-Proto

cp ${DEPLOY_PATH}/deploy/sormas.properties ${DOMAIN_DIR}
cp ${DEPLOY_PATH}/deploy/start-payara-sormas.sh ${DOMAIN_DIR}

chown -R ${USER_NAME}:${USER_NAME} ${DOMAIN_DIR}

#$GLASSFISH_PATH/bin/asadmin start-domain --domaindir $DOMAIN_PATH $DOMAIN_NAME > $LOG_PATH/$LOG_FILE_NAME

#sleep 10

#echo "Copying apk files..."
#cp ${DEPLOY_PATH}/deploy/android/release/*.apk ${DOWNLOADS_PATH}

echo "Copying server libs..."

cp ${DEPLOY_PATH}/deploy/serverlibs/* ${DOMAIN_DIR}/lib/

echo "Copying apps..."

mkdir -p ${DOMAIN_DIR}/deployments
cp ${DEPLOY_PATH}/deploy/apps/*.ear ${DOMAIN_DIR}/deployments/
cp ${DEPLOY_PATH}/deploy/apps/*.war ${DOMAIN_DIR}/deployments/

${PAYARA_HOME}/bin/asadmin stop-domain --domaindir ${DOMAINS_HOME}

rm -rf ${DOMAIN_DIR}/osgi-cache/*
rm -rf ${DOMAIN_DIR}/applications/*
rm -rf ${DOMAIN_DIR}/generated/*
rm -rf ${DOMAIN_DIR}/logs/*
rm -rf /opt/payara5/mq/javadoc
rm -rf /opt/payara5/mq/examples
rm -rf ${DEPLOY_PATH}

echo "Server setup completed."