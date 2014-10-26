using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Description;
using QuraanMemorizer.Models;
using QuraanMemorizer.DAL;

namespace QuraanMemorizer.Controllers
{
    public class SurrahController : ApiController
    {
        private ApplicationDbContext db = new ApplicationDbContext();

        // GET api/Surrah
        public IQueryable<Surrah> GetSurrah()
        {
            return db.Surrah;
        }

        // GET api/Surrah/5
        [ResponseType(typeof(Surrah))]
        public IHttpActionResult GetSurrah(int id)
        {
            Surrah surrah = db.Surrah.Find(id);
            if (surrah == null)
            {
                return NotFound();
            }

            return Ok(surrah);
        }

        // PUT api/Surrah/5
        public IHttpActionResult PutSurrah(int id, Surrah surrah)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != surrah.Id)
            {
                return BadRequest();
            }

            db.Entry(surrah).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!SurrahExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return StatusCode(HttpStatusCode.NoContent);
        }

        // POST api/Surrah
        [ResponseType(typeof(Surrah))]
        public IHttpActionResult PostSurrah(Surrah surrah)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.Surrah.Add(surrah);
            db.SaveChanges();

            return CreatedAtRoute("DefaultApi", new { id = surrah.Id }, surrah);
        }

        // DELETE api/Surrah/5
        [ResponseType(typeof(Surrah))]
        public IHttpActionResult DeleteSurrah(int id)
        {
            Surrah surrah = db.Surrah.Find(id);
            if (surrah == null)
            {
                return NotFound();
            }

            db.Surrah.Remove(surrah);
            db.SaveChanges();

            return Ok(surrah);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool SurrahExists(int id)
        {
            return db.Surrah.Count(e => e.Id == id) > 0;
        }
    }
}