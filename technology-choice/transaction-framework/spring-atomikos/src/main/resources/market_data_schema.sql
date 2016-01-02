DROP TABLE  MARKET_DATA_EOD_TX IF EXISTS;

CREATE TABLE  MARKET_DATA_EOD_TX (
   instrument varchar(100) not null,
   price      double not null
);
