FROM maven as build
WORKDIR /opt/aknms-backend
COPY . .
RUN mvn clean -DSkipTests package


FROM java:8
WORKDIR /opt/
EXPOSE 8080 8443
COPY --from=build /opt/aknms-backend/target/backend-*.jar .
CMD java -jar *.jar
