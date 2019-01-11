FROM maven as build
WORKDIR /opt/aknms-backend
COPY . .
RUN mvn clean -DSkipTests package


FROM java:8
WORKDIR /opt/
COPY --from=build /opt/aknms-backend/target/backend-*.jar .
CMD java -jar *.jar
