from scrapy.spider import Spider
from forbes.items import ForbesItem

class ForbesSpider(Spider):
  name = "forbes"
  allowed_domains = ["forbes.com"]
  start_urls = ["http://www.forbes.com/sites/natalierobehmed/2013/11/12/100-best-websites-for-entrepreneurs/"]

  def parse(self, response):
      for sel in response.xpath('//ul/li'):
          item = ForbesItem()
          item['title'] = sel.xpath('a/text()').extract()
          item['link'] = sel.xpath('a/@href').extract()
          item['desc'] = sel.xpath('text()').extract()
          yield item
