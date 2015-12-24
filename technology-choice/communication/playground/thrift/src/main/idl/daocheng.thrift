# play with thrift framework
# To define a service to check where the date is a weekend

include "daocheng_basic.thrift"

namespace java com.daocheng.idl.gen


service WeekendChecker {
  // To check whether a inputDate is a weekend
  bool isWeekend(1: daocheng_basic.NormalDate inDate)

}


