DROP TABLE  MARKET_DATA_EOD IF EXISTS;

CREATE TABLE  MARKET_DATA_EOD (
   instrument varchar(100) not null,
   price      double not null,
   closing_date date not null,
   xml_data CLOB
);
